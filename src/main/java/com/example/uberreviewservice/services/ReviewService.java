package com.example.uberreviewservice.services;

import com.example.uberreviewservice.enums.BookingStatus;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        /*
        Review r = Review
                .builder()
                .content("Amazing review")
                .rating(4.5)
                .build();
        Booking b = Booking
                .builder()
                .startTime(new Date())
                .endTime(new Date())
                .bookingStatus(BookingStatus.SCHEDULED)
                .review(r)
                .build();
        reviewRepository.save(r);
        bookingRepository.save(b);
        */
    }
}
