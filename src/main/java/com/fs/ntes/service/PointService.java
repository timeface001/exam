package com.fs.ntes.service;

import com.fs.ntes.domain.Point;

import java.util.List;
import java.util.Map;

public interface PointService {

    Point save(Point point);

    Point selectOneById(Integer pointId);

    int delPoint(Integer pointId,Integer itemId);

    List<Point> selectPointList(Map<String, Object> params);
}
