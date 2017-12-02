package com.fs.ntes.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("auth")
public class LoginController extends BaseController {


    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        System.out.println("exception=" + request.getParameter("username"));
        String msg = "";
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password"));
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            System.out.println(currentUser.isAuthenticated());
            System.out.println(JSON.toJSONString(getMember()));
        } catch (UnknownAccountException uae) {
            System.out.println("对用户[" + "]进行登录验证..验证未通过,未知账户");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("对用户[" + "]进行登录验证..验证未通过,错误的凭证");
        } catch (LockedAccountException lae) {
            System.out.println("对用户[" + "]进行登录验证..验证未通过,账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            System.out.println("对用户[" + "]进行登录验证..验证未通过,错误次数过多");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + "]进行登录验证..验证未通过,堆栈轨迹如下");
        }

        return "login";


    }


}
