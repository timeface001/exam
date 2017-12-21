package com.fs.ntes.service;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.Point;

import java.util.List;
import java.util.Map;

public interface ItemService {

    List<Item> selectList(Member member);

    boolean save(Item item);

    List<Point> selectPointList(Map<String, Object> params);

    Item findById(Integer id);

    Point saveItemPoint(Point point);

    int delItemPoint(Integer pointId,Integer itemId);
}
