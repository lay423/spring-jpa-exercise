package com.jpa.exercise.domain.repository;

import com.jpa.exercise.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

}
