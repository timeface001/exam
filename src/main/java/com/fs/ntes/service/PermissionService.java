package com.fs.ntes.service;

import com.fs.ntes.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> selectByRoleId(Long roleId);
}
