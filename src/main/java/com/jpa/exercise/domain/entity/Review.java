package com.jpa.exercise.domain.entity;

import com.jpa.exercise.domain.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public ReviewDto toResponse(String message){
        return ReviewDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .patientName(this.patientName)
                .message(message)
                .build();
    }

}
