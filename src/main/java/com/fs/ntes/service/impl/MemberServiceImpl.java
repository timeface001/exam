package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.ext.MemberExtMapper;
import com.fs.ntes.domain.stronger.MemberStg;
import com.fs.ntes.service.MemberService;
import com.fs.ntes.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberExtMapper memberExtMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public Member selectByUsername(String username) {
        return memberExtMapper.selectByUsername(username);
    }

    @Override
    public MemberStg selectStgByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        Member member= memberExtMapper.selectByUsername(username);

        if (Objects.isNull(member)) {
            return null;
        }
        MemberStg memberStg=new MemberStg();
        memberStg.setMember(member);
        memberStg.setRoleList(roleService.selectByMemberUid(Optional.ofNullable(member).map(g->member.getUid()).orElse(0L)));

        return memberStg;
    }
}
