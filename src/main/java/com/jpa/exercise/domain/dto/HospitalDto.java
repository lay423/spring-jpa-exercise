package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto  {
    private long id;
    private String name;
    private String roadNameAddress;
    private List<ReviewDto> reviews;

    public static HospitalDto of(Hospital hospital) {
        return HospitalDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .build();
    }
    public static HospitalDto of2(Hospital hospital, List<ReviewDto> reviews) {
        return HospitalDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(reviews)
                .build();
    }
}
