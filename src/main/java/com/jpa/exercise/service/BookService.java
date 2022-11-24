package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.BookDto;
import com.jpa.exercise.domain.entity.Book;
import com.jpa.exercise.domain.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public List<BookDto> getAll(){
//        List<Book> books = bookRepository.findAll();
//        List<BookDto> bookDtos = new ArrayList<>();
//        for (Book book : books) {
//            Optional<Author> optAuthor = authorRepository.findById(book.getAuthorId());
//
//            if (optAuthor.isEmpty()) {
//                bookDtos.add(new BookDto(book.getId(), book.getName(), "작가미상"));
//            } else {
//                bookDtos.add(new BookDto(book.getId(), book.getName(), optAuthor.get().getName()));
//            }
//        }
//        return bookDtos;
//    }

    public List<BookDto> getAll2(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookDto> bookDtos = books.stream()
                .map(book ->
                        BookDto.of(book)).collect(Collectors.toList());
        return bookDtos;
    }
}
