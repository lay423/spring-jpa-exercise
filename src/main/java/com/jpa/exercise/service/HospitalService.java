package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.HospitalDto;
import com.jpa.exercise.domain.dto.ReviewDto;
import com.jpa.exercise.domain.dto.ReviewRequest;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import com.jpa.exercise.domain.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;


    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<HospitalDto> getHospitals(Pageable pageable) {
        Page<Hospital> hospitalPage = hospitalRepository.findAll(pageable);
        List<HospitalDto> hospitalDtos = hospitalPage.stream()
                .map(hospital ->
                        HospitalDto.of(hospital)).collect(Collectors.toList());
        return hospitalDtos;
    }

//    public List<ReviewDto> getReviewByHospitals(Pageable pageable, long id) {
//        Page<Review> hospitalPage = hospitalRepository.findById(pageable);
//        List<HospitalDto> hospitalDtos = hospitalPage.stream()
//                .map(hospital ->
//                        HospitalDto.of(hospital)).collect(Collectors.toList());
//        return hospitalDtos;
//    }


}
