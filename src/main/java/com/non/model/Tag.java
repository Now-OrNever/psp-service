//package com.non.model;
//
//import jakarta.persistence.*;
//import jakarta.transaction.Transactional;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Transactional
//@Data
////@NoArgsConstructor
//@Table(name = "tags")
//public class Tag {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "question_tag", // Specify the name of the join table
//            joinColumns = @JoinColumn(name = "tag_id"), // Column in Tag entity
//            inverseJoinColumns = @JoinColumn(name = "question_id") // Column in Question entity
//    )
//    @Fetch(FetchMode.JOIN)
//    private List<Question> questions = new ArrayList<>();
//
//    public Tag() {
//    }
//
//    public Tag(long id, String name, List<Question> questions) {
//        this.id = id;
//        this.name = name;
//        this.questions = questions;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }
//}
