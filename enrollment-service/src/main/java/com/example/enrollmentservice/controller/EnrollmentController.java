package com.example.enrollmentservice.controller;

import com.example.enrollmentservice.dto.EnrollmentResponse;
import com.example.enrollmentservice.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public String enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        enrollmentService.enrollStudent(studentId, courseId);
        return "Student " + studentId + " enrolled in course " + courseId;
    }

    @GetMapping
    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}
