package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Question;
import com.fs.ntes.domain.em.Status;
import com.fs.ntes.domain.ext.ItemExtMapper;
import com.fs.ntes.domain.ext.PointExtMapper;
import com.fs.ntes.domain.ext.QuestionExtMapper;
import com.fs.ntes.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private PointExtMapper pointExtMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private ItemExtMapper itemExtMapper;

    @Override
    @Transactional
    public int save(Question question) {
        if (Objects.nonNull(question.getId())) {
            return questionExtMapper.updateByPrimaryKeySelective(question);

        } else {
            int i = questionExtMapper.insertSelective(question);
            //更新题目数量
            if (i == 1) {
                pointExtMapper.updateQuestionCount(question.getPointId(), question.getType(), 1);
                itemExtMapper.updateQuestionCount(question.getItemId(), 1);
            }
            return i;
        }
    }

    @Override
    public List<Question> selectListByPointId(Integer pointId, Integer type) {
        return questionExtMapper.selectListByPointId(pointId, type);
    }

    @Override
    public Question selectOneById(Integer questionId) {
        return questionExtMapper.selectByPrimaryKey(questionId);
    }

    @Override
    public int del(Integer pointId, Integer questionId, Integer questionType) {
        Question question = new Question();
        question.setId(questionId);
        question.setStatus(Status.DEL);
        int i = questionExtMapper.updateByPrimaryKeySelective(question);
        if (i == 1) {
            pointExtMapper.updateQuestionCount(pointId, questionType, -1);
            itemExtMapper.updateQuestionCount(question.getItemId(), -1);
        }

        return i;
    }
}
