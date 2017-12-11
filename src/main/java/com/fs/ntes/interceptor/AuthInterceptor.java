package com.fs.ntes.interceptor;

import com.fs.ntes.utils.LogUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        LogUtils.info("auth interceptor do start...");
        HttpSession session=request.getSession();
        if(Objects.nonNull(session.getAttribute("member"))){

        }else{
            response.sendRedirect(request.getContextPath()+"/auth/login");
        }

        LogUtils.info("auth interceptor do end...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

        LogUtils.info("");
    }
}
