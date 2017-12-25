package com.fs.ntes.domain.em;


public enum QuestionType {

    JUDGE(0, "判断题"), RADIO(1, "单选题"), CHECKBOX(2, "多选题"), SHORT(3, "简答题");

    private int type;
    private String desc;

    QuestionType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}