package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor // Generates a constructor with zero arguments.
@AllArgsConstructor // Generates a constructor with all fields as parameters.
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "bookingreview")
public class Review {
    @Id // This annotation makes the id property as Primary Key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Defines that id will be auto incremented
    private Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review: " + content + " " + rating + " " + createdAt;
    }
}
