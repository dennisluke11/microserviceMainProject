package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.Course;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController { 
	
	@Autowired
	CourseService courseService;
	
	
	
	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public Course save(@RequestBody Course course)
	{
		return courseService.save(course);
	}
	
	@RequestMapping(value = "/allCourse", method = RequestMethod.GET)
	public List<Course> getAllCourses()
	{
		return courseService.fetchAllCourses();
	}
	
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ResponseEntity<Course> fetchCourseById(@RequestParam int id) {

		Course student = courseService.fetchCourseById(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(student);
		}
	}

}
