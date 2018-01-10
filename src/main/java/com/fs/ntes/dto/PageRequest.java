package com.fs.ntes.dto;

import java.io.Serializable;
import java.util.Objects;

public class PageRequest implements Serializable {


    protected Integer pageSize;

    protected Integer pageNum;

    public Integer getPageSize() {
        return Objects.isNull(pageSize) || pageSize < 1 ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return Objects.isNull(pageNum) || pageNum < 1 ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
