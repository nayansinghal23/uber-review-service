package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass // Helps us to achieve inheritance in spring data jpa. No table for parent class. One table for each child class
public abstract class BaseModel {
    @Id // This annotation makes the id property as Primary Key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Defines that id will be auto incremented
    protected Long id;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    protected Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    protected Date updatedAt;
}
