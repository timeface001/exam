package com.fs.ntes.dto;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PageList<E> implements Serializable {
    private long totalSize;

    private int totalPages;

    private List<E> list;

    private int pageNum;

    private int pageSize;

    public PageList() {
    }

    public PageList(int totalSize, int totalPages, List<E> list, int pageNum, int pageSize) {
        this.totalSize = totalSize;
        this.totalPages = totalPages;
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageList(Page<E> page) {
        if (Objects.nonNull(page)) {
            this.list = page.getResult();
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalPages = page.getPages();
            this.totalSize = page.getTotal();
        } else {
            this.list = Collections.emptyList();
            this.pageNum = 1;
            this.pageSize = 10;
            this.totalPages = 1;
            this.totalSize = 0;
        }
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
