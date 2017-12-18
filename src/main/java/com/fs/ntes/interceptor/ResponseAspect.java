package com.fs.ntes.interceptor;

import com.alibaba.fastjson.JSON;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.utils.BeanUtils;
import com.fs.ntes.utils.LogUtils;
import com.fs.ntes.utils.oss.AliyunConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Aspect   //定义一个切面
@Configuration
public class ResponseAspect {

    // 定义切点Pointcut
    @Pointcut("execution(* com.fs.ntes.controller..*Controller.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        HttpSession session = request.getSession();
        if ((Objects.isNull(session) || Objects.isNull(session.getAttribute("member"))) && !uri.contains("/auth/login")) {
            return "redirect:./../auth/login";
        }
        LogUtils.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        LogUtils.info(request.getContextPath());
        request.setAttribute("basePath",request.getContextPath());
        request.setAttribute("aliyunPath", BeanUtils.getBean(AliyunConfig.class).getDomain());
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        if (result instanceof RespResult) {
            RespResult resp = (RespResult) result;
            if (resp.isView()) {
                return resp.getData();
            } else {
                LogUtils.info("请求结束，controller的返回值是 " + JSON.toJSONString(result));

                return resp;
            }
        }
        return result;
    }
}
