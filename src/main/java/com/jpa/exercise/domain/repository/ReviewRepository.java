package com.jpa.exercise.domain.repository;

import com.jpa.exercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
