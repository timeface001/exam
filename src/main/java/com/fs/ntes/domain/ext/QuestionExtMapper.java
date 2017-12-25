package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Question;
import com.fs.ntes.domain.mapper.QuestionMapper;

import java.util.List;

public interface QuestionExtMapper extends QuestionMapper{
    List<Question> selectListByPointId(Integer pointId);
}
