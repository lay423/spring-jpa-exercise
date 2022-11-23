package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.BookDto;
import com.jpa.exercise.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@Slf4j
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/list2")
//    public String getAll() {
//        StringBuilder stringBuilder = new StringBuilder();
//        List<BookDto> bookDtos =bookService.getAll();
//        List<ResponseEntity<BookDto>> responseEntities = new ArrayList<>();
//        BookDto bookDto = bookDtos.get(0);
//        log.info("id={}, name={}, authorName={}", bookDto.getId(), bookDto.getName(), bookDto.getAuthorName());
//
//        for (BookDto dto : bookDtos) {
//            stringBuilder.append(
//                    String.format("{\"id\":\"%d\", \"name\":\"%s\", \"authorName\":\"%s\"}<br>",
//                            dto.getId(),
//                            dto.getName(),
//                            dto.getAuthorName())+"");
//        }
//        String response = String.valueOf(stringBuilder);
//
//        return response;
//    }

    @GetMapping("/lists")
    public ResponseEntity<List<BookDto>> getAll2(Pageable pageable) {
        List<BookDto> bookDtos= bookService.getAll2(pageable);
        BookDto bookDto = bookDtos.get(0);
        log.info("id={}, name={}, authorName={}", bookDto.getId(), bookDto.getName(), bookDto.getAuthorName());
        return ResponseEntity.ok().body(bookService.getAll2(pageable));
    }
}
