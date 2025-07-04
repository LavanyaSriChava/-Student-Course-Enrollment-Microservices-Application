package com.example.paymentservice.service;

import com.example.paymentservice.client.CourseClient;
import com.example.paymentservice.client.StudentClient;
import com.example.paymentservice.dto.CourseDTO;
import com.example.paymentservice.dto.PaymentResponse;
import com.example.paymentservice.dto.StudentDTO;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final StudentClient studentClient;
    private final CourseClient courseClient;

    public PaymentResponse makePayment(Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());
        Payment savedPayment = paymentRepository.save(payment);

        StudentDTO student = studentClient.getStudentById(payment.getStudentId());
        CourseDTO course = courseClient.getCourseById(payment.getCourseId());

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(savedPayment.getId());
        response.setAmount(savedPayment.getAmount());
        response.setPaymentDate(savedPayment.getPaymentDate());
        response.setStudent(student);
        response.setCourse(course);

        return response;
    }
}
