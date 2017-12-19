package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.ItemPoint;
import com.fs.ntes.domain.mapper.ItemPointMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemPointExtMapper extends ItemPointMapper {
    List<ItemPoint> selectList(Map<String, Object> map);

    int delById(@Param("id") Integer pointId);
}
