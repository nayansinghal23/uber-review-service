package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class Review {
    @Id // This annotation makes the id property as Primary Key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Defines that id will be auto incremented
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    Date updatedAt;
}
