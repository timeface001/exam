package com.fs.ntes.domain.stronger;

import com.fs.ntes.domain.Permission;
import com.fs.ntes.domain.Role;

import java.util.List;

public class RoleStg {

    private Role role;

    private List<Permission> permissions;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
