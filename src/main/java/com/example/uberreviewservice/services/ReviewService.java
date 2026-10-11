package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
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
        Optional<Driver> driver = driverRepository.findByIdAndLicenseNumber(1L, "DL121212");
        if (driver.isPresent()) {
            System.out.println(driver.get().getName());
            List<Booking> bookings = driver.get().getBookings();
            for (Booking booking : bookings) System.out.println(booking.getId());
        }
    }
}
