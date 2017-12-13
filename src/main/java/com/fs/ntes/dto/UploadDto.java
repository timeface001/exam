package com.fs.ntes.dto;

import com.fs.ntes.utils.oss.AliyunConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadDto {

    @Autowired
    private AliyunConfig aliyunConfig;

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
        data.setAbsSrc(aliyunConfig.getDomain() + src);
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

        public Data(String absSrc, String src) {
            this.absSrc = aliyunConfig.getDomain() + src;
            this.src = src;
        }
    }
}
