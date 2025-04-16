package com.microservice.course.service.interfaces;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.exception.ResourceNotFoundException;
import com.microservice.course.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    CourseDTO save(Course course);
    List<CourseDTO> findAll();
    Optional<CourseDTO> findById(Long id) throws ResourceNotFoundException;
    CourseDTO update(Long id, Course course) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
