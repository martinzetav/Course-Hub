package com.microservice.course.mapper;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDTO(Course course);
    Course toEntity(CourseDTO courseDTO);


}
