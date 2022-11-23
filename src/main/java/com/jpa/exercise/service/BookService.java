package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.BookDto;
import com.jpa.exercise.domain.entity.Author;
import com.jpa.exercise.domain.entity.Book;
import com.jpa.exercise.domain.repository.AuthorRepository;
import com.jpa.exercise.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookDto> getAll(){
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            Optional<Author> optAuthor = authorRepository.findById(book.getAuthorId());

            if (optAuthor.isEmpty()) {
                bookDtos.add(new BookDto(book.getId(), book.getName(), "작가미상"));
            } else {
                bookDtos.add(new BookDto(book.getId(), book.getName(), optAuthor.get().getName()));
            }
        }
        return bookDtos;
    }
}
