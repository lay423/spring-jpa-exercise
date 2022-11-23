package com.jpa.exercise.domain.repository;

import com.jpa.exercise.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
