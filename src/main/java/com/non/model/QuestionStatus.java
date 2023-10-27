package com.non.model;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="QuestionStatus_tbl")
public class QuestionStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
}