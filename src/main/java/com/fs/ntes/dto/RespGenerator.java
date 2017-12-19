package com.fs.ntes.dto;

import com.fs.ntes.utils.BeanUtils;

public class RespGenerator<T> {


    public static RespResult generateSuccess() {
        RespResult result = new RespResult();
        result.setCode(BeanUtils.getBean(ResultCode.class).getCommon().getSuccess());
        result.setSuccess(true);
        return result;
    }

    public static <T> RespResult generateSuccess(T data) {
        RespResult result = new RespResult();
        result.setCode(BeanUtils.getBean(ResultCode.class).getCommon().getSuccess());
        result.setSuccess(true);
        return result;
    }

    public static <T> RespResult generateSuccessDependBol(boolean bol) {
        RespResult result = new RespResult();
        result.setCode(BeanUtils.getBean(ResultCode.class).getCommon().getSuccess());
        result.setSuccess(bol);
        return result;
    }

    public static String generateSuccessView(String view) {
        return view;
    }

    public static String generateSuccessViewRedirect(String view) {
        return generateSuccessView("redirect:" + view);
    }
}
