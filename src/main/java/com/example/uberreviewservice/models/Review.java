package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor // Generates a constructor with zero arguments.
@AllArgsConstructor // Generates a constructor with all fields as parameters.
@Entity
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {
    @Column(nullable = false)
    private String content;

    private Double rating;

    @Override
    public String toString() {
        return "Review: " + content + " " + rating + " " + super.createdAt;
    }
}
