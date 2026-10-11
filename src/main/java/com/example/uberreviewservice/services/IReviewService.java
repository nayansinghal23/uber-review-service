package com.example.uberreviewservice.services;

import com.example.uberreviewservice.dtos.CreateReviewDTO;
import com.example.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {
    List<Review> getAllReviews();
    Review createReview(CreateReviewDTO dto);
    Optional<Review> getReviewById(Long reviewId);
    boolean updateReviewById(Long reviewId, Review review);
    boolean deleteReviewById(Long reviewId);
}
