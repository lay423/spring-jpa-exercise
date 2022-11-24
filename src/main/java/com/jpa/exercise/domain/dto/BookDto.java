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
    private String publisherName;

    public static BookDto of(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthor().getName())
                .publisherName(book.getPublisher().getName())
                .build();
    }
}
