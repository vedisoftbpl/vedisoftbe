package com.vedisoft.vedisoft2020.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vedisoft.vedisoft2020.pojos.Student;
import com.vedisoft.vedisoft2020.services.IStudentService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		System.out.println("inside student");
		List<Student> list = studentService.getAllStudents();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/student/formSubmit")
	public ResponseEntity<Void> createStudent(@RequestBody Student student){
		Student createdStudent = studentService.createStudent(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdStudent.getRegistrationId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/student/formEdit/{studentId}")
	public ResponseEntity<Student> editStudent(@PathVariable long studentId, @RequestBody Student student){
		Student studentEdited = studentService.createStudent(student);
		return new ResponseEntity<Student>(studentEdited, HttpStatus.OK);
	}
}
