package com.non.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "INT")
    private Integer id;
    @Column(name = "title", columnDefinition = "VARCHAR(255)")
    private String title;
    @Column(name = "link", columnDefinition = "VARCHAR(255)")
    private String link;

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Question() {
    }

    public Question(String title, String link) {
        this.title = title;
        this.link = link;
    }
}
