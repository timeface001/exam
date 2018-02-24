package com.fs.ntes.dto;

import com.fs.ntes.domain.Point;

import java.io.Serializable;

public class PaperPointSelectDto implements Serializable {

    private boolean choose;

    private Point point;

    private Integer totalCount;

    private Integer selectCount;

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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

    public PaperPointSelectDto(Point point, Integer selectCount) {
        this.point = point;
        this.selectCount = selectCount;
        this.choose = selectCount > 0;
    }

    public PaperPointSelectDto() {
    }
}
