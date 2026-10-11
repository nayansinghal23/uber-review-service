package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) return false;

        reviewRepository.deleteById(reviewId);
        return true;
    }

    @Override
    public boolean updateReviewById(Long reviewId, Review review) {
        if (!reviewRepository.existsById(reviewId)) return false;

        review.setId(reviewId); // Ensure the ID matches the path variable
        reviewRepository.save(review);
        return true;
    }
}
