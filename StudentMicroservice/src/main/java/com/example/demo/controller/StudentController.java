package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.Student;
import com.example.demo.demo.StudentDetails;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/student")
@RefreshScope
public class StudentController { 
	
	@Autowired
	StudentService studentService;
	
	@Value("${message:default message}")
    private String message;
	
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@GetMapping("/id")
	public StudentDetails getById(@RequestParam(value = "id", defaultValue = "1") int id) {
		
		return studentService. getById(id);
	}
	
	@GetMapping("/idwebclient")
	public StudentDetails getByIdUsingWebClient(@RequestParam(value = "id", defaultValue = "1") int id) {
		//logger.info("/idwebclient");
		return studentService.getByIdUsingWebClient(id);
	}
	
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student)
	{
		return studentService.save(student);
	}
	
	@RequestMapping(value = "/allStudent", method = RequestMethod.GET)
	public List<Student> getAllStudents()
	{
		return studentService.fetchAllStudent();
	}
	
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ResponseEntity<Student> fetchStudentById(@RequestParam int id) {

		Student student = studentService.fetchStudentById(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(student);
		}
	}

}
