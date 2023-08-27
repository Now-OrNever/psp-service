package com.non.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import java.util.List;

@Entity
@Transactional
@Table(name = "questions")
public class Question {
    @Id
    private String questionId;
    private String questionName;
    private String questionLink;
    private String level;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<User> users = new ArrayList<>();

    public Question() {
    }

    public Question(String questionId, String questionName, String questionLink, String level) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.questionLink = questionLink;
        this.level = level;
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
    public String getQuestionLink() {
        return questionLink;
    }

    public void setQuestionLink(String questionLink) {
        this.questionLink = questionLink;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}