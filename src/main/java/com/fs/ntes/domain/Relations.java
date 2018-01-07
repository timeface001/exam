package com.fs.ntes.domain;

public class Relations {
    private Integer initialId;

    private Integer referId;

    private Integer referType;

    private String remark;

    public Integer getInitialId() {
        return initialId;
    }

    public void setInitialId(Integer initialId) {
        this.initialId = initialId;
    }

    public Integer getReferId() {
        return referId;
    }

    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public Integer getReferType() {
        return referType;
    }

    public void setReferType(Integer referType) {
        this.referType = referType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}