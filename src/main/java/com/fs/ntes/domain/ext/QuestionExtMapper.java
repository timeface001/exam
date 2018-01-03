package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Question;
import com.fs.ntes.domain.mapper.QuestionMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionExtMapper extends QuestionMapper{
    List<Question> selectListByPointId(@Param("pointId") Integer pointId,@Param("type") Integer type);
}
