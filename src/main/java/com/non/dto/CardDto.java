package com.non.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CardDto {
    private Integer id;
    private String name;
    private String timeComp;
    private String comment;
    private String memComp;
    private String difficulty;
    private String bookmark;
}
