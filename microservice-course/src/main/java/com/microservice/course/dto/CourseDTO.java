package com.microservice.course.dto;

public record CourseDTO(Long id,
                        String title,
                        String description,
                        Double price) {
}
