package com.fs.ntes.domain.stronger;

import com.fs.ntes.domain.Member;

import java.util.List;

public class MemberStg {
    private Member member;

    private List<RoleStg> roleList;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<RoleStg> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleStg> roleList) {
        this.roleList = roleList;
    }
}
