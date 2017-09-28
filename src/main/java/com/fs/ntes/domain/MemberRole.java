package com.fs.ntes.domain;

import java.util.Date;

public class MemberRole {
    private Long roleId;

    private Long memberUid;

    private Date creareTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMemberUid() {
        return memberUid;
    }

    public void setMemberUid(Long memberUid) {
        this.memberUid = memberUid;
    }

    public Date getCreareTime() {
        return creareTime;
    }

    public void setCreareTime(Date creareTime) {
        this.creareTime = creareTime;
    }
}