package com.fs.ntes.controller;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.PasswordAuthentication;

@Controller
@RequestMapping("auth")
public class LoginController {


    @RequestMapping("/login")
    public String login(String username, String password) {

        UsernamePasswordToken token=new UsernamePasswordToken(username,password,true);
        SecurityUtils.getSubject().login(token);

        return "login";


    }


}
