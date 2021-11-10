package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Todo;
import com.ibm.service.TodoService;

@CrossOrigin()
@RestController
public class TodoController {

	@Autowired
	private TodoService service;
	
	@PostMapping(value = "/todo/{userid}", consumes = "application/json")
	public void addTodo(@RequestBody Todo todo, @PathVariable int userid) {
		int id = service.addTodo(todo, userid);
		System.out.println("ToDo created with Id: " + id);
	}
	
	@GetMapping(value = "/todo/{id}", produces = "application/json")
	public Todo getTodo(@PathVariable int id) {
		return service.getTodo(id);
	}
	
	@GetMapping(value = "/todo/user/{userid}", produces = "application/json")
	public List<Todo> getUserTodo(@PathVariable int userid) {
		return service.todoByUser(userid);
	}
}
