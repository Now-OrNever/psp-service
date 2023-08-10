package com.non.model;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "day_tbl")
public class Day {
    @Id
    private Long did;
    private String topic;
    private Integer totalQuestion;
    private Boolean isLock;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id", referencedColumnName = "did")
    private List<Question> questions = new ArrayList<>();

    public Day(long did, String topic, Integer totalQuestion, Boolean isLock, List<Question> questions) {
        this.did = did;
        this.topic = topic;
        this.totalQuestion = totalQuestion;
        this.isLock = isLock;
        this.questions = questions;
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(Integer totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public Boolean isLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
