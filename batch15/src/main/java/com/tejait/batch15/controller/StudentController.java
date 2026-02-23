package com.tejait.batch15.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.model.Student;
import com.tejait.batch15.service.StudentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
	
	StudentService service;

	@PostMapping(value = "saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student savedstudent = service.savestudent(student);
		return new ResponseEntity<>(savedstudent, HttpStatus.CREATED);
	}

	@PutMapping(value = "updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updatedstudent = service.savestudent(student);
		return new ResponseEntity<>(updatedstudent, HttpStatus.OK);
	}

	@DeleteMapping(value = "deleteStudentId/{id}")
	public ResponseEntity<String> deletebyStudentId(@PathVariable Integer id) {
		service.deleteStudent(id);
		return new ResponseEntity<>("deletedStudent " + id, HttpStatus.OK);
	}

	@GetMapping(value = "getByStudentId/{id}")
	public ResponseEntity<Student> getByStudentId(@PathVariable Integer id) {
		java.util.Optional<Student> stuobj=service.getById(id);
		return new ResponseEntity<>(stuobj.get(),HttpStatus.OK);
		
	}
	@GetMapping(value="getAll")
	public ResponseEntity<List<Student>> getAllStus(){
		List<Student> list=service.getAllstus();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
