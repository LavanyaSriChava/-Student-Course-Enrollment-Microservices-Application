package com.example.paymentservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Long paymentId;
    private Double amount;
    private LocalDateTime paymentDate;
    private StudentDTO student;
    private CourseDTO course;
}
