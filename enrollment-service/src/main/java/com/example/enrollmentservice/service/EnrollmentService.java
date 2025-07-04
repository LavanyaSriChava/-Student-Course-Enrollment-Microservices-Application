package com.example.enrollmentservice.service;

import com.example.enrollmentservice.client.CourseClient;
import com.example.enrollmentservice.client.StudentClient;
import com.example.enrollmentservice.model.Enrollment;
import com.example.enrollmentservice.model.StudentDTO;
import com.example.enrollmentservice.model.CourseDTO;
import com.example.enrollmentservice.repository.EnrollmentRepository;
import com.example.enrollmentservice.dto.EnrollmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final StudentClient studentClient;
    private final CourseClient courseClient;
    private final EnrollmentRepository enrollmentRepository;

    public void enrollStudent(Long studentId, Long courseId) {
        // Optional: Validate student and course exist
        studentClient.getStudentById(studentId);
        courseClient.getCourseById(courseId);

        Enrollment enrollment = Enrollment.builder()
                .studentId(studentId)
                .courseId(courseId)
                .enrollmentDate(LocalDate.now())
                .build();

        enrollmentRepository.save(enrollment);
    }

    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentRepository.findAll().stream().map(enrollment -> {
            StudentDTO student = studentClient.getStudentById(enrollment.getStudentId());
            CourseDTO course = courseClient.getCourseById(enrollment.getCourseId());

            EnrollmentResponse response = new EnrollmentResponse();
            response.setEnrollmentId(enrollment.getId());
            response.setEnrollmentDate(enrollment.getEnrollmentDate());
            response.setStudent(student);
            response.setCourse(course);
            return response;
        }).collect(Collectors.toList());
    }
}
