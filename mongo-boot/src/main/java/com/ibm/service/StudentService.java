package com.ibm.service;

import java.util.List;

import com.ibm.model.Student;

public interface StudentService {
	
	void save(Student s);
	
	Student fetch(int rollNo);
	
	List<Student> fetchAll();

	void delete(int rollNo);
}
