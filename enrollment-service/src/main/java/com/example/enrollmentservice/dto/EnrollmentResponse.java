package com.example.enrollmentservice.dto;

import com.example.enrollmentservice.model.CourseDTO;
import com.example.enrollmentservice.model.StudentDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentResponse {
    private Long enrollmentId;
    private LocalDate enrollmentDate;
    private StudentDTO student;
    private CourseDTO course;
}
