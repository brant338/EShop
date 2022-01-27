package com.wangshidai.eshopFront.entity;

public class PwdQuestion {

    private Integer question_id;
    private String question_title;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    @Override
    public String toString() {
        return "PwdQuestion{" +
                "question_id=" + question_id +
                ", question_title='" + question_title + '\'' +
                '}';
    }
}
