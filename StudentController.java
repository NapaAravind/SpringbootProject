package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@PostMapping("/student")
	public ResponseEntity<Student> admitStudent(@RequestBody Student student){
		Student savedStudent=studentRepository.save(student);
		
		return new ResponseEntity<Student>(savedStudent, HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students=studentRepository.findAll();
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
		Student savedStudent=studentRepository.findById(id).get();
		return new ResponseEntity<Student>(savedStudent, HttpStatus.OK);
	}
	
	
}
