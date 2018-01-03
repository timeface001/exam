package com.fs.ntes.controller;

import com.fs.ntes.domain.Member;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    protected Member getMember(){
        return (Member) getRequest().getSession().getAttribute("member");
    }

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected void setAttribute(String key, Object value) {
        getRequest().setAttribute(key, value);
    }



}
