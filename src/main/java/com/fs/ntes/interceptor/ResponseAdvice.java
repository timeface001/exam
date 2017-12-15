package com.fs.ntes.interceptor;

import com.fs.ntes.dto.RespResult;
import com.fs.ntes.utils.LogUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<RespResult> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return false;
    }

    @Override
    public RespResult beforeBodyWrite(RespResult o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        LogUtils.info("数据返回");
        /*if(isPage){
            return o.getData();
        }*/
        o.setCode("11");
        LogUtils.info(o.toString());

        return o;
    }
}
