package com.non.model;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name="QuestionStatus_tbl")
public class QuestionStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String questionId;
    private String status;
    private String approach;
    private String memoryComplexity;
    private String timeComplexity;
    private String difficultyLevel;
    private String note;
    @ManyToOne
    private Question question;

    public QuestionStatus(Long id, String userId, String questionId, String status, String approach, String memoryComplexity, String timeComplexity, String difficultyLevel, String note, Question question) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.status = status;
        this.approach = approach;
        this.memoryComplexity = memoryComplexity;
        this.timeComplexity = timeComplexity;
        this.difficultyLevel = difficultyLevel;
        this.note = note;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getMemoryComplexity() {
        return memoryComplexity;
    }

    public void setMemoryComplexity(String memoryComplexity) {
        this.memoryComplexity = memoryComplexity;
    }

    public String getTimeComplexity() {
        return timeComplexity;
    }

    public void setTimeComplexity(String timeComplexity) {
        this.timeComplexity = timeComplexity;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
