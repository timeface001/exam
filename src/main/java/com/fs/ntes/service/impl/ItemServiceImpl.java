package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.Point;
import com.fs.ntes.domain.ext.ItemExtMapper;
import com.fs.ntes.domain.ext.PointExtMapper;
import com.fs.ntes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemExtMapper itemExtMapper;

    @Override
    public List<Item> selectList(Member member) {
        return itemExtMapper.selectList(member);
    }

    @Override
    public boolean save(Item item) {
        return itemExtMapper.insertSelective(item) == 1;
    }

    @Override
    public Item findById(Integer id) {
        return itemExtMapper.selectByPrimaryKey(id);
    }




}
