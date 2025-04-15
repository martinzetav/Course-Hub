package com.microservice.course.service.interfaces;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    CourseDTO save(Course course);
    List<CourseDTO> findAll();
    Optional<CourseDTO> findById(Long id);
    CourseDTO update(Long id, Course course);
    void delete(Long id);
}
