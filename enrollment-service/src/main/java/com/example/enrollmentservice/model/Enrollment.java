package com.example.enrollmentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student Id is required")
    private Long studentId;

    @NotNull(message = "Course Id is required")
    private Long courseId;

    @NotNull(message = "Enrollment date is required")
    private LocalDate enrollmentDate;
}