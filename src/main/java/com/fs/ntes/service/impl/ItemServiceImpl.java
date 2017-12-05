package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.ext.ItemExtMapper;
import com.fs.ntes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemExtMapper itemExtMapper;

    @Override
    public List<Item> selectList(Member member) {
        return itemExtMapper.selectList(member);
    }
}
