package com.exampleRest.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
            new Course(1, "Ioannis", "test"),
            new Course(2, "Eleftheriadis", "test2"),
            new Course(3, "Antonis", "test2")
        );
    }
}
