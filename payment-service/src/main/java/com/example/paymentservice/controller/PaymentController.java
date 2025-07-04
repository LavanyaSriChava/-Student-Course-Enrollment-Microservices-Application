package com.example.paymentservice.controller;

import com.example.paymentservice.client.CourseClient;
import com.example.paymentservice.client.StudentClient;
import com.example.paymentservice.dto.CourseDTO;
import com.example.paymentservice.dto.PaymentInfo;
import com.example.paymentservice.dto.StudentDTO;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository paymentRepository;
    private final StudentClient studentClient;
    private final CourseClient courseClient;

    @PostMapping
    public Payment makePayment(@RequestBody Payment paymentRequest) {
        Payment payment = Payment.builder()
                .studentId(paymentRequest.getStudentId())
                .courseId(paymentRequest.getCourseId())
                .amount(paymentRequest.getAmount())
                .paymentDate(LocalDateTime.now())
                .build();

        return paymentRepository.save(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public List<Payment> getPaymentsByStudent(@PathVariable Long studentId) {
        return paymentRepository.findByStudentId(studentId);
    }
    @GetMapping("/info")
    public List<PaymentInfo> getAllPaymentInfo() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentInfo> infoList = new ArrayList<>();

        for (Payment payment : payments) {
            var student = studentClient.getStudentById(payment.getStudentId());
            var course = courseClient.getCourseById(payment.getCourseId());

            PaymentInfo info = new PaymentInfo(
                    payment.getId(),
                    student.getName(),
                    course.getName(),
                    payment.getAmount(),
                    payment.getPaymentDate()
            );
            infoList.add(info);
        }

        return infoList;
    }


    // ✅ Inter-service test endpoint
    @GetMapping("/info/{studentId}/{courseId}")
    public String getPaymentInfo(@PathVariable Long studentId, @PathVariable Long courseId) {
        StudentDTO student = studentClient.getStudentById(studentId);
        CourseDTO course = courseClient.getCourseById(courseId);

        return "Student: " + student.getName() + " is enrolled in Course: " + course.getName();
    }
}
