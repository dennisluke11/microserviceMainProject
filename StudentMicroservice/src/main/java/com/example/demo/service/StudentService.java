package com.example.demo.service;


import java.util.List;

import com.example.demo.demo.Student;
import com.example.demo.demo.StudentDetails;

public interface StudentService {
	
	Student save(Student student);
	
	Student fetchStudentById(int id);
	
	List<Student> fetchAllStudent();
	
	StudentDetails getById(int id);
	
	StudentDetails getByIdUsingWebClient(int id);

}
