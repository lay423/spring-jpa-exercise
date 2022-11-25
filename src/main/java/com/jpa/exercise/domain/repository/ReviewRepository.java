package com.jpa.exercise.domain.repository;

import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findAllByHospital(Hospital hospital);
}
