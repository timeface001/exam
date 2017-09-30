package com.fs.ntes.domain.mapper;

import com.fs.ntes.domain.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}