package com.example.uberreviewservice.adapters;

import com.example.uberreviewservice.dtos.CreateReviewDTO;
import com.example.uberreviewservice.models.Review;

public interface CreateReviewDtoToReviewAdaptor {
    Review convertDTO(CreateReviewDTO dto);
}
