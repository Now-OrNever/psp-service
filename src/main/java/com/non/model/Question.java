package com.non.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "question_tbl")
public class Question {
    //    level
    @Id
    private String questionId;
    private String questionName;
    private List<String> tags;
    private String questionLink;

    //    private String notes;
//    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<QuestionStatus> questionStatuses;

    public Question(String questionId, String questionName, List<String> tags, String questionLink, List<QuestionStatus> questionStatuses) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.tags = tags;
        this.questionLink = questionLink;
        this.questionStatuses = questionStatuses;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getQuestionLink() {
        return questionLink;
    }

    public void setQuestionLink(String questionLink) {
        this.questionLink = questionLink;
    }

    public List<QuestionStatus> getQuestionStatuses() {
        return questionStatuses;
    }

    public void setQuestionStatuses(List<QuestionStatus> questionStatuses) {
        this.questionStatuses = questionStatuses;
    }
}
