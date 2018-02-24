package com.fs.ntes.dto;

import com.fs.ntes.domain.Question;

import java.io.Serializable;

public class PaperQuestionSelectDto implements Serializable {
    private boolean choose;

    private Question question;

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public PaperQuestionSelectDto() {
    }

    public PaperQuestionSelectDto(boolean choose, Question question) {
        this.choose = choose;
        this.question = question;
    }
}
