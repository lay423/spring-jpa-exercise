package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.HospitalDto;
import com.jpa.exercise.domain.dto.ReviewDto;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalRestController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseEntity<List<HospitalDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(hospitalService.getHospitals(pageable));
    }


    @PostMapping("{id}/reviews")
    public ResponseEntity<ReviewDto> addReview(@PathVariable long id, @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok().body(reviewService.addReview(id, reviewRequest));
    }

    @GetMapping("{id}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewsByHospitalId(@PathVariable long id) {
        return ResponseEntity.ok().body(reviewService.getReviewsByHospitalId(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<HospitalDto> getHospitalById(@PathVariable long id) {
        return ResponseEntity.ok().body(hospitalService.getHospitalById(id));
    }
}
