package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.ReviewDto;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import com.jpa.exercise.domain.repository.HospitalRepository;
import com.jpa.exercise.domain.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ReviewDto> getReviews(Pageable pageable) {
        Page<Review> reviewPage = reviewRepository.findAll(pageable);
        List<ReviewDto> reviewDtos = reviewPage.stream()
                .map(review ->
                        ReviewDto.of(review)).collect(Collectors.toList());
        return reviewDtos;
    }

    public ReviewDto getReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        Review savedReview;
        if(optionalReview.isPresent())
            return ReviewDto.of(optionalReview.get());
        else
            return ReviewDto.builder().message("존재하지 않는 리뷰id입니다.").build();

    }
}
