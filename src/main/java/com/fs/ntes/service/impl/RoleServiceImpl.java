package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Permission;
import com.fs.ntes.domain.Role;
import com.fs.ntes.domain.ext.PermissionExtMapper;
import com.fs.ntes.domain.ext.RoleExtMapper;
import com.fs.ntes.domain.stronger.RoleStg;
import com.fs.ntes.service.PermissionService;
import com.fs.ntes.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleExtMapper roleExtMapper;

    @Autowired
    private PermissionService permissionService;

    @Override
    public List<RoleStg> selectByMemberUid(Long uid) {
        return roleExtMapper.selectListByMemberUid(uid).stream().map(role->{return new RoleStg();}).collect(Collectors.toList());
    }
}
