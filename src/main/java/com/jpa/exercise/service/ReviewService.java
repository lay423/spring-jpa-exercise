package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.ReviewDto;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.repository.HospitalRepository;
import com.jpa.exercise.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;
    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewDto addReview(long id, ReviewRequest reviewRequest) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital;
        if(optionalHospital.isPresent())
            hospital = optionalHospital.get();
        else
            hospital = new Hospital(404L, "없음", "없음");
        return reviewRepository.save(reviewRequest.toEntity(hospital)).toResponse("등록이 성공했습니다.");
    }
}
