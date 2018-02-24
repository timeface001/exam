package com.fs.ntes.service.impl;

import com.fs.ntes.domain.em.RelationType;
import com.fs.ntes.domain.ext.PointExtMapper;
import com.fs.ntes.domain.ext.RelationsExtMapper;
import com.fs.ntes.service.RelationsService;
import com.fs.ntes.utils.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RelationsServiceImpl implements RelationsService {

    @Autowired
    private RelationsExtMapper relationsExtMapper;

    @Autowired
    private PointExtMapper pointExtMapper;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public boolean updatePaperQuestion(Integer paperId, Integer pointId, List<Integer> questionIds) {

        relationsExtMapper.paperQuestionRelation(questionIds, paperId, pointId);
        //先删除知识点
        relationsExtMapper.delRelations(paperId, null, RelationType.PAPER_POINT.getType());
        if (GeneralUtils.isNotNullOrEmpty(questionIds)) {//删除知识点
            relationsExtMapper.paperPointRelation(pointExtMapper.selectPointIdsByQuestionIds(questionIds), paperId);
        }
        //relationsExtMapper.paperItemRelation(itemIds, paperId);
        //relationsExtMapper.paperPointRelation(pointIds, paperId);
        return true;
    }

    @Override
    public List<Integer> selectQuestionIdsByPaperId(Integer paperId, Integer pointId) {
        return relationsExtMapper.selectQuestionIdsByPaperIdAndPointId(paperId, pointId);
    }

    @Override
    public Integer countPointSelect(Integer paperId, Integer pointId) {
        return relationsExtMapper.countPointSelect(paperId, pointId);
    }
}
