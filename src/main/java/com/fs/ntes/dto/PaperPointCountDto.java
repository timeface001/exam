package com.fs.ntes.dto;

import com.fs.ntes.utils.GeneralUtils;

import java.io.Serializable;
import java.util.List;

public class PaperPointCountDto implements Serializable {

    private List<PaperPointSelectDto> list;

    private String typeName;

    private Integer totalCount;//总题数

    private Integer selectCount;//已选题目数

    public List<PaperPointSelectDto> getList() {
        return list;
    }

    public void setList(List<PaperPointSelectDto> list) {
        this.list = list;
        if (GeneralUtils.isNotNullOrEmpty(list)) {
            this.totalCount = list.stream().mapToInt(PaperPointSelectDto::getTotalCount).sum();
            this.selectCount = list.stream().mapToInt(PaperPointSelectDto::getSelectCount).sum();

        } else {
            this.totalCount = 0;
            this.selectCount = 0;
        }
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(Integer selectCount) {
        this.selectCount = selectCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
