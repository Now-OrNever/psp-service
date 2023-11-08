package com.non.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuesDto {
    private Integer id;
    private String title;
    private String link;
    private List<QuesStatusDto> questionStatus = new ArrayList<>();
    private List<CardDto> cards = new ArrayList<>();
}
