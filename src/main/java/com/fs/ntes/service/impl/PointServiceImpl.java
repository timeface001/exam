package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Point;
import com.fs.ntes.domain.ext.ItemExtMapper;
import com.fs.ntes.domain.ext.PointExtMapper;
import com.fs.ntes.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PointServiceImpl  implements PointService {

    @Autowired
    private PointExtMapper pointExtMapper;

    @Autowired
    private ItemExtMapper itemExtMapper;

    @Override
    @Transactional(readOnly = false)
    public Point save(Point point) {
        if (Objects.nonNull(point.getId())) {
            point.setUpdateUid(point.getCreateUid());
            point.setCreateUid(null);
            pointExtMapper.updateByPrimaryKeySelective(point);
            return point;
        } else {

            itemExtMapper.updatePointCount(point.getItemId(), 1);
            pointExtMapper.insertSelective(point);
            return point;
        }
    }

    @Override
    public Point selectOneById(Integer pointId) {
        return pointExtMapper.selectByPrimaryKey(pointId);
    }


    @Override
    @Transactional(readOnly = false)
    public int delPoint(Integer pointId, Integer itemId) {
        itemExtMapper.updatePointCount(itemId, -1);
        itemExtMapper.updateQuestionCount(itemId, pointExtMapper.selectByPrimaryKey(pointId).getQuestionCount());
        return pointExtMapper.delById(pointId);
    }

    @Override
    public List<Point> selectPointList(Map<String, Object> params) {
        return pointExtMapper.selectList(params);
    }
}
