package com.fs.ntes.domain.stronger;

import com.fs.ntes.domain.Member;

import java.util.List;
import java.util.Optional;

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

    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return Optional.ofNullable(member).map((g) -> g.getUsername() + g.getSalt()).orElse("");
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解

}
