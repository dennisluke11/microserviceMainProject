package com.example.demo.service;


import java.util.List;

import com.example.demo.demo.Course;

public interface CourseService {
	
	Course save(Course course);
	
	Course fetchCourseById(int id);
	
	List<Course> fetchAllCourses();

}
