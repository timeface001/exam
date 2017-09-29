package com.fs.ntes.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = {"com.fs.ntes.domain.mapper","com.fs.ntes.domain.ext"})
public class MybatisConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String configLocation;
    private String mapperLocations;
    private String executorType;

    @Autowired
    private DataSource dataSource;


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        logger.info("Initialize SqlSessionFactory...mapperLocations={}", configLocation);
        SqlSessionFactory sqlSessionFactory = null;
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            //设置数据源 datasource
            sqlSessionFactoryBean.setDataSource(dataSource);

            //设置 configLocation
            logger.info("Read mybatis config location from config file is '{}'", configLocation);
            configLocation = StringUtils.isBlank(configLocation) ? "mybatis/mybatis-config.xml" : configLocation;

            Resource resource = new ClassPathResource(configLocation);
            if (!resource.exists()) {
                throw new Exception("Can not found mybatis-config.xml at '" + configLocation + "'");
            } else {
                sqlSessionFactoryBean.setConfigLocation(resource);
            }

            //设置 mapperLocations
            mapperLocations = StringUtils.isBlank(mapperLocations) ? "classpath*:/mybatis/mappers/**/*.xml" :
                    mapperLocations;
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new
                    PathMatchingResourcePatternResolver();
            Resource[] mapperLocationsRes = pathMatchingResourcePatternResolver.getResources(mapperLocations);
            if (mapperLocationsRes != null && mapperLocationsRes.length > 0) {
                sqlSessionFactoryBean.setMapperLocations(mapperLocationsRes);
            } else {
                logger.warn("Set mapper locations failed. Can not found any file in path '{}'", mapperLocations);
            }

            // http://git.oschina.net/free/Mybatis_PageHelper/blob/master/wikis/HowToUse.markdown
            Properties prop = new Properties();
            //4.0.0以后版本可以不设置该参数
            prop.setProperty("dialect", "mysql");
            //设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用和startPage中的pageNum效果一样
            prop.setProperty("offsetAsPageNum", "true");
            //设置为true时，使用RowBounds分页会进行count查询
            prop.setProperty("rowBoundsWithCount", "true");
            //设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果
            prop.setProperty("pageSizeZero", "true");
            // 3.3.0版本可用 - 分页参数合理化，默认false禁用
            // 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
            // 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
            prop.setProperty("reasonable", "false");
            //支持通过Mapper接口参数来传递分页参数
            prop.setProperty("supportMethodsArguments", "false");
            //always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page
            prop.setProperty("returnPageInfo", "none");
            // 分页插件
            PageHelper pagePlugin = new PageHelper();
            pagePlugin.setProperties(prop);

            Interceptor[] plugins = {pagePlugin};
            if (logstashClient.getLogstashConfig().isLogDatebase()) {
                MybatisExecutorLogInterceptor sqlLogInterceptor = new MybatisExecutorLogInterceptor(logstashClient);
                sqlLogInterceptor.setExcludeSqlCommandTypes(SqlCommandType.SELECT);
                sqlLogInterceptor.setExcludeSqlIds("com.czy.tticar.mapper.base.LogRequestMapper.insertSelective");
                plugins = new Interceptor[]{sqlLogInterceptor, pagePlugin};
            }
            sqlSessionFactoryBean.setPlugins(plugins);

            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            LogUtils.error("init sqlSessionFactory failed.", e);
            System.exit(1);
        }
        return sqlSessionFactory;
    }

    // 事务支持
    @Bean
    @Order
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Scope(value = "prototype") // 保证线程安全
    public SqlSessionTemplate sqlSessionTemplate() {
        ExecutorType et = StringUtils.isBlank(executorType) ?
                ExecutorType.REUSE : "SIMPLE".equals(executorType) ?
                ExecutorType.SIMPLE : "BATCH".equals(executorType) ?
                ExecutorType.BATCH : ExecutorType.REUSE;

        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
            logger.info("Initialize SqlSessionTemplate bean with sqlSessionFactory '{}'", sqlSessionFactory);
            //默认采用Batch方式提交事务
            //SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
            // 默认采用REUSE方式提交事务
            SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory, et);
            return sqlSessionTemplate;
        } catch (Exception e) {
            return null;
        }
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getExecutorType() {
        return executorType;
    }

    public void setExecutorType(String executorType) {
        this.executorType = executorType;
    }
}
