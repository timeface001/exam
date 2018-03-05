package com.fs.ntes.service;

import com.fs.ntes.domain.em.RelationType;

import java.util.List;

public interface RelationsService {

    boolean updatePaperQuestion(Integer paperId, Integer pointIds, List<Integer> questionIds);

    List<Integer> selectQuestionIdsByPaperId(Integer paperId, Integer pointId);

    Integer countPointSelect(Integer paperId, Integer pointId, Integer type);
}
