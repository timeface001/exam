package com.fs.ntes.domain;

import java.util.Date;

public class Point {
    private Integer id;

    private String name;

    private Integer itemId;

    private Integer status;

    private Integer judgeCount;

    private Integer radioCount;

    private Integer checkboxCount;

    private Integer shortCount;

    private Long createUid;

    private Long updateUid;

    private Integer questionCount;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getJudgeCount() {
        return judgeCount;
    }

    public void setJudgeCount(Integer judgeCount) {
        this.judgeCount = judgeCount;
    }

    public Integer getRadioCount() {
        return radioCount;
    }

    public void setRadioCount(Integer radioCount) {
        this.radioCount = radioCount;
    }

    public Integer getCheckboxCount() {
        return checkboxCount;
    }

    public void setCheckboxCount(Integer checkboxCount) {
        this.checkboxCount = checkboxCount;
    }

    public Integer getShortCount() {
        return shortCount;
    }

    public void setShortCount(Integer shortCount) {
        this.shortCount = shortCount;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Long getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Long updateUid) {
        this.updateUid = updateUid;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}