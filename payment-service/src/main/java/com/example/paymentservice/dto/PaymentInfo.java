package com.example.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PaymentInfo {
    private Long paymentId;
    private String studentName;
    private String courseTitle;
    private Double amount;
    private LocalDateTime paymentDate;
}
