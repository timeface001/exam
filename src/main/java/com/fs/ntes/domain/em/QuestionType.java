package com.fs.ntes.domain.em;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public enum QuestionType {

    JUDGE(0, "判断题"), RADIO(1, "单选题"), CHECKBOX(2, "多选题"), SHORT(3, "简答题");

    private int type;
    private String desc;

    QuestionType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static String getTypeDesc(Integer type) {
        if (Objects.isNull(type)) {
            return StringUtils.EMPTY;
        }
        for (QuestionType qt : QuestionType.values()) {
            if (qt.getType() == type) {
                return qt.getDesc();
            }
        }
        return StringUtils.EMPTY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}