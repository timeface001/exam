package com.fs.ntes.domain.mapper;

import com.fs.ntes.domain.Relations;

public interface RelationsMapper {
    int insert(Relations record);

    int insertSelective(Relations record);
}