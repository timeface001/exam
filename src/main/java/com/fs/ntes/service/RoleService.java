package com.fs.ntes.service;

import com.fs.ntes.domain.stronger.RoleStg;

import java.util.List;

public interface RoleService {

    List<RoleStg> selectByMemberUid(Long uid);
}
