package com.scaffolding.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Seat {

    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    private String sid;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    private int count;
    @JsonIgnore
    @JoinColumn(name = "train_tid")
    @ManyToOne
    private Train train;

}
