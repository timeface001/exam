package com.fs.ntes.service;

import com.fs.ntes.domain.Question;

import java.util.List;

public interface QuestionService {

    int save(Question question);

    List<Question> selectListByPointId(Integer pointId);

}
