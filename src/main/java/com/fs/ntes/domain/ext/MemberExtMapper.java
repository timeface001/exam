package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.mapper.MemberMapper;

public interface MemberExtMapper extends MemberMapper {

    Member selectByUsername(String username);

}
