package com.jpa.exercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private long id;
    private String name;
    private String authorName;
}
