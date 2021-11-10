package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
