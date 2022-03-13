package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.demo.Course;
import com.example.demo.demo.Student;
import com.example.demo.demo.StudentDetails;
import com.example.demo.repository.StudentRepository;

import reactor.core.publisher.Mono;

@Service
public class StudentServiceImp implements StudentService{
	
	
	@Autowired
	StudentRepository  studentRepository;
	
	@Autowired ApiCall apiCall;   // using restTemplate
	
	@Autowired ApiCallUsingWebClient apiCallUsingWebClient; // using webClient

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student fetchStudentById(int id) {
		
		Optional<Student> student = studentRepository.findById(id);
		
		if(student.isPresent()) {
			
			return student.get();
			
		}
		
		return null;
		}

	@Override
	public List <Student> fetchAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public StudentDetails getById(int id) {
		// getting student from table by passing id
				Student s = studentRepository.findById(id).orElse(null);
				
				//getting course from course microservice by call API
				Course course = apiCall.getCourseDetails(s.getCourseId());
				
				StudentDetails sd = new StudentDetails();
				BeanUtils.copyProperties(s, sd);
				sd.setCourse(course);
				return sd;
	}

	@Override
	public StudentDetails getByIdUsingWebClient(int id) {
		// getting student from table by passing id
				Student s = studentRepository.findById(id).orElse(null);
				
				//getting course from course microservice by call API
				Mono<Course> courseMono = apiCallUsingWebClient.getCourseDetails(s.getCourseId());
				Course course = courseMono.block();
				
				StudentDetails sd = new StudentDetails();
				// copying properties from student to studentdetail object
				BeanUtils.copyProperties(s, sd);
				sd.setCourse(course);
				return sd;
	}
	

}
