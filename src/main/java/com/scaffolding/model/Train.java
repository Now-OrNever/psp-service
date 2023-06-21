package com.scaffolding.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Train {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tName;
    private String source;
    private String destination;
    private double fare;
    private Long duration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "train")
    private Set<Seat> seats = new HashSet<>();

}
