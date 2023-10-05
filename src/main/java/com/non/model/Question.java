package com.non.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    private String level;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "questions")
    private List<User> users;

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

    public Question() {
        this.users = new ArrayList<>();
    }

    public Question(String title, String link, String level) {
        this.title = title;
        this.link = link;
        this.level = level;
    }
}
