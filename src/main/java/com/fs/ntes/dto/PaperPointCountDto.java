package com.fs.ntes.dto;

import com.fs.ntes.utils.GeneralUtils;

import java.io.Serializable;
import java.util.List;

public class PaperPointCountDto implements Serializable {

    private List<PaperPointSelectDto> list;

    private String typeName;

    private Long totalCount;//总题数

    private Long selectCount;//已选题目数

    public List<PaperPointSelectDto> getList() {
        return list;
    }

    public void setList(List<PaperPointSelectDto> list) {
        this.list = list;
        if (GeneralUtils.isNotNullOrEmpty(list)) {
            this.totalCount = list.stream().mapToInt(PaperPointSelectDto::getTotalCount).count();
            this.selectCount = list.stream().mapToInt(PaperPointSelectDto::getSelectCount).count();

        }
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(Long selectCount) {
        this.selectCount = selectCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
