package com.fs.ntes.controller;

import com.fs.ntes.domain.Member;
import org.apache.shiro.SecurityUtils;

public class BaseController {

    protected Member getMember(){
        return (Member) SecurityUtils.getSubject().getPrincipal();
    }

}
