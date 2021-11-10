package com.ibm.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class ContentController {
	
	@GetMapping(value= "/greet/{name}", produces= "text/plain")
	public String greetText(@PathVariable String name) {
		return "Welcome to Spring Boot, " + name;
	}
	
	@GetMapping(value= "/greet", produces= "text/html")
	public String greetHtml(@RequestParam String name) {
		return "<h1>Welcome to Spring Boot, " + name + "</h1>";
	}
	
	@GetMapping(value= "/greet", produces="text/xml")
	public String greetXml() {
		return "<?xml version=\"1.0\"><greeting>Welcome to Spring Boot</greeting>";
	}
	
	@GetMapping(value="/greet", produces="application/json")
	public String greetJson() {
		JSONPObject obj = new JSONPObject("greeting", "Welcome to Spring Boot");
		return obj.toString();
		}
}
