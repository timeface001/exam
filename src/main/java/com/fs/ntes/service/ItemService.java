package com.fs.ntes.service;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.Point;

import java.util.List;
import java.util.Map;

public interface ItemService {

    List<Item> selectList(Member member);

    boolean save(Item item);

    Item findById(Integer id);


}
