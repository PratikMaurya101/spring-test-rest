package com.orangotan.springtestrest.controller;

import com.orangotan.springtestrest.entity.Course;
import com.orangotan.springtestrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String Home(){
        return "this is home page";
    }

    //get all courses
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses();
    }

    //fetches course by id
    @GetMapping("/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable("courseId") String courseId){
        long id = Long.parseLong(courseId);
        return this.courseService.getCourse(id);
    }

    //adds new courses
    @PostMapping(path="/courses",consumes = "application/json")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping(path = "/courses", consumes = "application/json")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") String courseId){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
