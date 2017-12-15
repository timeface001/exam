package com.fs.ntes.domain.mapper;

import com.fs.ntes.domain.ItemPoint;

public interface ItemPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemPoint record);

    int insertSelective(ItemPoint record);

    ItemPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemPoint record);

    int updateByPrimaryKey(ItemPoint record);
}