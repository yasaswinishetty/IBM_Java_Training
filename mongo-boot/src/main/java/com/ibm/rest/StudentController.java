package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.Student;
import com.ibm.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(value="/student", consumes="application/json")
	public String addStudent(@RequestBody Student s) {
		service.save(s);
		return "Student Added";
	}
	
	@GetMapping(value="/student/{rollNo}", produces="application/json")
	public Student getStudent(@PathVariable int rollNo) {
		return service.fetch(rollNo);
	}
	
	@GetMapping(value="/students", produces="application/json")
	public List<Student> getAll() {
		return service.fetchAll();
	}
	
	@DeleteMapping(value="/student/{rollNo}")
	public String delStudent(@PathVariable int rollNo) {
		service.delete(rollNo);
		return "Student Deleted";
	}
}
