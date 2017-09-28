package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Permission;
import com.fs.ntes.domain.mapper.PermissionMapper;

import java.util.List;

public interface PermissionExtMapper extends PermissionMapper{

    List<Permission> selectListByRoleId(Long roleId);
}
