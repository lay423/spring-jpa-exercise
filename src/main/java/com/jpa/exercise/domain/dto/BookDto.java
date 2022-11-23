package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private long id;
    private String name;
    private String authorName;

    public static BookDto of(Book book, String authorName) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(authorName)
                .build();
    }
}
