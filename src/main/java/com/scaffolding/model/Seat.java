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
    @Column(columnDefinition = "INT")
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    private Integer sid;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    private int count;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_tid", referencedColumnName = "tid")
    private Train train;

}
