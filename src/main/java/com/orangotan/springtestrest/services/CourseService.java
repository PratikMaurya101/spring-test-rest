package com.orangotan.springtestrest.services;

import com.orangotan.springtestrest.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getCourses();
    public Optional<Course> getCourse(long courseId);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public Course deleteCourse(long courseId);
}
