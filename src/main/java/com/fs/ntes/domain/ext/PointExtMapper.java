package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Point;
import com.fs.ntes.domain.mapper.PointMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PointExtMapper extends PointMapper {
    List<Point> selectList(Map<String, Object> map);

    int delById(@Param("id") Integer pointId);

    int updateQuestionCount(@Param("pointId") Integer pointId,@Param("type") int questionType,@Param("count") Integer count);

    List<Point> selectListByItemIds(@Param("itemIds") List<Integer> list);

    List<Integer> selectPointIdsByQuestionIds(@Param("questionIds") List<Integer> questionIds);

}
