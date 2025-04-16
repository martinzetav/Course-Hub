package com.microservice.course.service.impl;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.exception.ResourceNotFoundException;
import com.microservice.course.mapper.CourseMapper;
import com.microservice.course.model.Course;
import com.microservice.course.repository.ICourseRepository;
import com.microservice.course.service.interfaces.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDTO save(Course course) {
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<CourseDTO> findById(Long id) throws ResourceNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            return Optional.of(courseMapper.toDTO(course.get()));
        } else {
            throw new ResourceNotFoundException("Course with id " + id + " not found.");
        }
    }

    @Override
    public CourseDTO update(Long id, Course course) throws ResourceNotFoundException {
        Optional<Course> wantedCourse = courseRepository.findById(id);
        if(wantedCourse.isPresent()){
            Course updatedCourse = wantedCourse.get();
            updatedCourse.setTitle(course.getTitle());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setInstructorId(course.getInstructorId());
            updatedCourse.setPrice(course.getPrice());
            updatedCourse.setIsActive(course.getIsActive());
            courseRepository.save(updatedCourse);
            return courseMapper.toDTO(updatedCourse);
        } else {
            throw new ResourceNotFoundException("Course with id " + id + " not found.");
        }
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id " + id + " not found."));

        courseRepository.deleteById(course.getId());
    }
}
