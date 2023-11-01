package com.non.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String timeComp;
    private String memComp;
    private String comment;
    private String difficulty;
    private String bookmark;

    @ManyToOne
    private Question question;

    @ManyToOne
    private User user;

}
