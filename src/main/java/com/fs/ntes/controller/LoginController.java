package com.fs.ntes.controller;

import com.fs.ntes.domain.stronger.MemberStg;
import com.fs.ntes.service.MemberService;
import com.fs.ntes.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Controller
@RequestMapping("auth")
public class LoginController extends BaseController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        MemberStg member = memberService.selectStgByUsername(username);
        if (Objects.nonNull(member) && StringUtils.equals(member.getMember().getPassword(), MD5Utils.EncoderByMd5(password))) {
            request.getSession(true).setAttribute("member", member.getMember());
            request.getSession(true).setAttribute("memberStg", member);
            return "redirect:./../index/index";
        }


        return "login";


    }


}
