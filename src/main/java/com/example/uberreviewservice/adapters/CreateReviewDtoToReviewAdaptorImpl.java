package com.example.uberreviewservice.adapters;

import com.example.uberentityservice.models.Booking;
import com.example.uberentityservice.models.Review;
import com.example.uberreviewservice.dtos.CreateReviewDTO;
import com.example.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdaptorImpl implements CreateReviewDtoToReviewAdaptor {
    private final BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdaptorImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDTO(CreateReviewDTO dto) {
        Optional<Booking> booking = bookingRepository.findById(dto.getBookingId());
        if (booking.isEmpty()) throw new IllegalArgumentException("Review cannot be created without a booking.");

        return Review
                .builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .booking(booking.get())
                .build();
    }
}
