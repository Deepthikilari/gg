package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentPojo;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/user")
public class StudentController {
	@Autowired
	StudentService ss;
	
	@GetMapping(value="/select")
   public List<StudentPojo> getall(){
		List<StudentPojo> all=	ss.getalldetails();
	return all;		
	}
	
	@PostMapping(value="/create")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retrieve the badge.svg thanks to the redirect", content = @Content(mediaType = "image/svg+xml")),
			@ApiResponse(responseCode = "303", description = "Redirect to https://img.shields.io/badge/{domaine-name}-{expiration-date}-{color}", content = @Content(mediaType = "image/svg+xml")),
			@ApiResponse(responseCode = "400", description = "Bad request. Invalid extension", content = @Content(mediaType = MediaType.ALL_VALUE)),
			@ApiResponse(responseCode = "404", description = "Domaine not found", content = @Content(mediaType = MediaType.ALL_VALUE)) })

	@Operation(summary = "getall student data")
	public String createstudent(@RequestBody StudentPojo student) {
		return ss.create(student);
	}
	
	@PutMapping("/{id}")
	public StudentPojo update(@PathVariable int id,@RequestBody StudentPojo student){
		return ss.update(id, student);		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
		ss.delete(id);
		
	}
}
