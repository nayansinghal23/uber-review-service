package com.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
public class PassengerReview extends Review { // Driver gives a passenger review
    private String passengerReviewComment;
    private double passengerRating;
}
