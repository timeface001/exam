package com.fs.ntes.service;

import java.util.List;

public interface RelationsService {

    boolean updatePaperQuestion(Integer paperId, Integer pointIds, List<Integer> questionIds);

    List<Integer> selectQuestionIdsByPaperId(Integer paperId, Integer pointId);
}
