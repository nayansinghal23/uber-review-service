package com.example.uberreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "com.example.uberentityservice.models")
public class UberReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberReviewServiceApplication.class, args);
    }

}
