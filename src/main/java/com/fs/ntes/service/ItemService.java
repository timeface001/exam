package com.fs.ntes.service;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.ItemPoint;
import com.fs.ntes.domain.Member;

import java.util.List;
import java.util.Map;

public interface ItemService {

    List<Item> selectList(Member member);

    boolean save(Item item);

    List<ItemPoint> selectPointList(Map<String, Object> params);

    Item findById(Integer id);
}
