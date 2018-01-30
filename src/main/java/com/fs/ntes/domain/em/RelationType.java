package com.fs.ntes.domain.em;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public enum RelationType {

    PAPER_ITEM(0, "试卷关联题库"), PAPER_POINT(1, "试卷关联知识点"), PAPER_QUESTION(2, "试卷关联问题");

    private int type;
    private String desc;

    RelationType(int type, String desc) {
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
