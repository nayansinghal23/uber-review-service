package com.example.uberreviewservice.controllers;

import com.example.uberreviewservice.adapters.CreateReviewDtoToReviewAdaptor;
import com.example.uberreviewservice.dtos.CreateReviewDTO;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.services.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final IReviewService reviewService;
    private final CreateReviewDtoToReviewAdaptor createReviewDtoToReviewAdaptor;

    public ReviewController(IReviewService reviewService, CreateReviewDtoToReviewAdaptor createReviewDtoToReviewAdaptor) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdaptor = createReviewDtoToReviewAdaptor;
    }

    @GetMapping("")
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.status(HttpStatus.OK).body(reviews);
    }

    @PostMapping("")
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDTO dto) {
        try {
            Review review = createReviewDtoToReviewAdaptor.convertDTO(dto);
            reviewService.createReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId) {
        try {
            Optional<Review> review = reviewService.getReviewById(reviewId);
            return ResponseEntity.status(HttpStatus.OK).body(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId) {
        try {
            boolean isDeleted =  reviewService.deleteReviewById(reviewId);
            if (isDeleted) return ResponseEntity.status(HttpStatus.OK).body("Review deleted successfully");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete review");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReviewById(@PathVariable Long reviewId, @RequestBody Review review) {
        try {
            boolean isUpdated =  reviewService.updateReviewById(reviewId, review);
            if (isUpdated) return ResponseEntity.status(HttpStatus.OK).body("Review updated successfully");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to update review");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
