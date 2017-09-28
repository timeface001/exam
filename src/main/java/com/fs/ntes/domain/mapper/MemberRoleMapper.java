package com.fs.ntes.domain.mapper;

import com.fs.ntes.domain.MemberRole;

public interface MemberRoleMapper {
    int insert(MemberRole record);

    int insertSelective(MemberRole record);
}