package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private long id;
    private String hospitalName;
    private String patientName;
    private String title;
    private String content;
    private String message;

    public static ReviewDto of(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .hospitalName(review.getHospital().getName())
                .message("불러오기 완료")
                .build();
    }
}
