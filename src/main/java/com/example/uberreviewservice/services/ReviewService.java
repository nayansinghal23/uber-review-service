package com.example.uberreviewservice.services;

import com.example.uberreviewservice.dtos.CreateReviewDTO;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review createReview(CreateReviewDTO dto) {
        Optional<Booking> booking = bookingRepository.findById(dto.getBookingId());
        if (booking.isEmpty()) throw new IllegalArgumentException("Review cannot be created without a booking.");

        Review review = Review
                .builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .booking(booking.get())
                .build();
        reviewRepository.save(review);
        return review;
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
