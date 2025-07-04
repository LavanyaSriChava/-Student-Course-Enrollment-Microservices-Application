package com.example.paymentservice.client;

import com.example.paymentservice.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "http://localhost:8081/students")
public interface StudentClient {
    @GetMapping("/{id}")
    StudentDTO getStudentById(@PathVariable Long id);
}
