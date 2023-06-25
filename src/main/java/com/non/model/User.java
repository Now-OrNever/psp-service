package com.non.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Timestamp create_time;
    private Timestamp update_time;
    private Integer created_by;
    private Integer updated_by;

    @Column(unique = true, nullable = false)
    private String username;
    private String first_name;
    private String last_name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(columnDefinition = "boolean default false")
    private boolean is_deleted;

    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    public enum ROLE {
        ADMIN,
        MENTOR,
        MENTEE
    }

    public User() {
    }

    public User(String username, String first_name, String last_name, String email, ROLE role) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = role;
    }

    public User(String username, String first_name, String last_name, String email) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
}
