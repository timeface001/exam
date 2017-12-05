package com.fs.ntes.service;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Member;

import java.util.List;

public interface ItemService {

    List<Item> selectList(Member member);
}
