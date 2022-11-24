package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private long hospitalId;
    private String patientName;
    private String title;
    private String content;

    public Review toEntity(Hospital hospital){
        return Review.builder()
                .title(this.title)
                .content(this.content)
                .patientName(this.patientName)
                .hospital(hospital)
                .build();
    }
}
