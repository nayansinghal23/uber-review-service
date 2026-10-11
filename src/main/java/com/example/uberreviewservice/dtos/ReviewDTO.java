package com.example.uberreviewservice.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private String content;
    private double rating;
    private Long bookingId;
    private Date createdAt;
    private Date updatedAt;
}
