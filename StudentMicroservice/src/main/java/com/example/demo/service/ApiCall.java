package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.demo.Course;



@Service
public class ApiCall {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiCall.class);
	
	@Autowired RestTemplate restTemplate;
	
	private static final String courseMisroserviceBaseURL = 
			"http://course-service";
	
	public Course getCourseDetails(int courseId) {
	
	Course course = restTemplate.getForObject(
			courseMisroserviceBaseURL + "/course/course?id={courseId}", 
			Course.class, courseId);
	return course;
	}
	
	public Course fallback(Exception ex) {
		logger.info("calling fallback and returning default course data");
		Course course = new Course();
		course.setId(1);
		course.setName("common-course");
		course.setMuda(1);
		return course;
	} 
	
}