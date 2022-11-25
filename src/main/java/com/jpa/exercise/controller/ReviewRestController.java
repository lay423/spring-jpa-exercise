package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.ReviewDto;
import com.jpa.exercise.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@Slf4j
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable long id) {
        return ResponseEntity.ok().body(reviewService.getReview(id));
    }

    @GetMapping("")
    public ResponseEntity<List<ReviewDto>> getReview(Pageable pageable){
        return ResponseEntity.ok().body(reviewService.getReviews(pageable));
    }
}
