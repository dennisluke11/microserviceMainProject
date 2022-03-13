package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.demo.Course;
import com.example.demo.repository.CourseRepository;

import java.util.List;


@Service
public class CourseServiceImp implements CourseService{
	
	
	@Autowired
	CourseRepository  courseRepository;

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course fetchCourseById(int id) {
		
		Optional<Course> course = courseRepository.findById(id);
		
		if(course.isPresent()) {
			
			return course.get();
			
		}
		
		return null;
		}

	@Override
	public List <Course> fetchAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}
	

}
