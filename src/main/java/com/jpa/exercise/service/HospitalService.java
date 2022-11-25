package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.HospitalDto;
import com.jpa.exercise.domain.dto.ReviewDto;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import com.jpa.exercise.domain.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewService reviewService;

    public List<HospitalDto> getHospitals(Pageable pageable) {
        Page<Hospital> hospitalPage = hospitalRepository.findAll(pageable);
        List<HospitalDto> hospitalDtos = hospitalPage.stream()
                .map(hospital ->
                        HospitalDto.of(hospital)).collect(Collectors.toList());
        return hospitalDtos;
    }

    public HospitalDto getHospitalById(long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Id가 없습니다."));
        List<ReviewDto> reviews = reviewService.getReviewsByHospitalId(id);
        return HospitalDto.of2(hospital, reviews);
    }
}
