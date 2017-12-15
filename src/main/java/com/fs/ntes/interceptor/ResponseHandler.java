package com.fs.ntes.interceptor;

import com.fs.ntes.dto.RespResult;
import com.fs.ntes.utils.BeanUtils;
import com.fs.ntes.utils.LogUtils;
import com.fs.ntes.utils.oss.AliyunConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ResponseHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        LogUtils.info("参数返回");

        //response.sendRedirect();

        HandlerMethod method = (HandlerMethod)o;
       // RespResult resp = method.getMethodAnnotation(RespResult.class);
        request.setAttribute("aliyunPath", BeanUtils.getBean(AliyunConfig.class).getDomain());


    }
}
