package com.fs.ntes.service;

import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.stronger.MemberStg;

public interface MemberService {

    Member selectByUsername(String username);

    MemberStg selectStgByUsername(String username);
}
