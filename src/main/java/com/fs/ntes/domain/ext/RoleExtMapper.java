package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Role;
import com.fs.ntes.domain.mapper.RoleMapper;

import java.util.List;

public interface RoleExtMapper extends RoleMapper{

    List<Role> selectListByMemberUid(Long uid);

}
