package com.example.uberreviewservice.services;

import com.example.uberentityservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {
    List<Review> getAllReviews();
    void createReview(Review review);
    Optional<Review> getReviewById(Long reviewId);
    boolean updateReviewById(Long reviewId, Review review);
    boolean deleteReviewById(Long reviewId);
}
