package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalReadResponse {

    private long id;
    private String name;
    private String roadNameAddress;
    private List<ReviewDto> reviews;

    public static HospitalReadResponse of3(Hospital hospital) {
        return HospitalReadResponse.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews().stream()
                        .map(review -> ReviewDto.of(review)).collect(Collectors.toList()))
                .build();
    }

}
