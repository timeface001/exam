package com.fs.ntes.dto;

import com.fs.ntes.utils.BeanUtils;
import com.fs.ntes.utils.oss.AliyunConfig;

public class UploadDto {

    private int code;

    private String msg;

    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public UploadDto() {
    }

    public UploadDto(int code, String msg, String src) {
        this.code = code;
        this.msg = msg;
        this.data = this.new Data();
        data.setSrc(src);
        data.setAbsSrc(BeanUtils.getBean(AliyunConfig.class).getDomain() + src);
    }

    public class Data {

        private String absSrc;

        public String getAbsSrc() {
            return absSrc;
        }

        public void setAbsSrc(String absSrc) {
            this.absSrc = absSrc;
        }

        private String src;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public Data() {

        }

    }
}
