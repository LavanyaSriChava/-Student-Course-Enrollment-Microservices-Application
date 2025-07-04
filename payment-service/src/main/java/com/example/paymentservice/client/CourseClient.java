package com.example.paymentservice.client;

import com.example.paymentservice.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service", url = "http://localhost:8082/courses")
public interface CourseClient {
    @GetMapping("/{id}")
    CourseDTO getCourseById(@PathVariable Long id);
}
