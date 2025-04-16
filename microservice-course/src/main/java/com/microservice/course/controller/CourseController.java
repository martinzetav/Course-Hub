package com.microservice.course.controller;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.exception.ResourceNotFoundException;
import com.microservice.course.model.Course;
import com.microservice.course.service.interfaces.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<CourseDTO> course = courseService.findById(id);
        ResponseEntity response;
        if(course.isPresent()){
            response = ResponseEntity.ok(course.get());
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody Course course) throws ResourceNotFoundException {
        Optional<CourseDTO> requiredCourse = courseService.findById(id);
        ResponseEntity response;
        if(requiredCourse.isPresent()){
            response = ResponseEntity.ok(courseService.update(id, course));
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        courseService.delete(id);
        return ResponseEntity.ok("Course with id " + id + " successfully removed.");
    }


}
