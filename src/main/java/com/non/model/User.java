package com.non.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String name;
    @ManyToMany(mappedBy = "users", cascade={CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Question> userQues = new ArrayList<>();

    public User() {
    }

    public User(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getUserQues() {
        return userQues;
    }

    public void setUserQues(List<Question> userQues) {
        this.userQues = userQues;
    }
}
