package com.example.interviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.interviews"})
public class InterviewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewsApplication.class, args);
    }
}
