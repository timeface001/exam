package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Permission;
import com.fs.ntes.domain.ext.PermissionExtMapper;
import com.fs.ntes.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionExtMapper permissionExtMapper;

    @Override
    public List<Permission> selectByRoleId(Long roleId) {
        return permissionExtMapper.selectListByRoleId(roleId);
    }
}
