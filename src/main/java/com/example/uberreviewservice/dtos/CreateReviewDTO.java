package com.example.uberreviewservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDTO {
    private final String content;
    private final Long bookingId;

    private double rating;

    public CreateReviewDTO(String content, Long bookingId) {
        this.content = content;
        this.bookingId = bookingId;
    }
}
