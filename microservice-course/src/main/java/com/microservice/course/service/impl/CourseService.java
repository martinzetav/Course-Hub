package com.microservice.course.service.impl;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.model.Course;
import com.microservice.course.service.interfaces.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {
    @Override
    public CourseDTO save(Course course) {
        return null;
    }

    @Override
    public List<CourseDTO> findAll() {
        return List.of();
    }

    @Override
    public Optional<CourseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CourseDTO update(Long id, Course course) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
