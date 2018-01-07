package com.fs.ntes.domain;

import java.util.Date;

public class Paper {
    private Integer id;

    private String name;

    private Integer finishStatus;

    private Integer status;

    private Integer questionCount;

    private Integer score;

    private String scoreDetailJson;

    private String description;

    private String items;

    private String pointJson;

    private String questionTypeJson;

    private Long uid;

    private String uname;

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

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreDetailJson() {
        return scoreDetailJson;
    }

    public void setScoreDetailJson(String scoreDetailJson) {
        this.scoreDetailJson = scoreDetailJson == null ? null : scoreDetailJson.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items == null ? null : items.trim();
    }

    public String getPointJson() {
        return pointJson;
    }

    public void setPointJson(String pointJson) {
        this.pointJson = pointJson == null ? null : pointJson.trim();
    }

    public String getQuestionTypeJson() {
        return questionTypeJson;
    }

    public void setQuestionTypeJson(String questionTypeJson) {
        this.questionTypeJson = questionTypeJson == null ? null : questionTypeJson.trim();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
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