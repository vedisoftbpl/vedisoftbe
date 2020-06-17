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

import com.vedisoft.vedisoft2020.pojos.StudentBatch;
import com.vedisoft.vedisoft2020.services.IStudentBatchService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class StudentBatchController {
	@Autowired
	private IStudentBatchService studentBatchService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/studentBatchs")
	public ResponseEntity<List<StudentBatch>> getAllStudentBatchs() {
		System.out.println("inside studentBatch");
		List<StudentBatch> list = studentBatchService.getAllStudentBatch();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<StudentBatch>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/studentBatch/{id}")
	public ResponseEntity<StudentBatch> getStudentBatchById(@PathVariable("id") int id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		StudentBatch studentBatch = studentBatchService.getStudentBatchById(id);
		return new ResponseEntity<StudentBatch>(studentBatch, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/studentBatch/formSubmit")
	public ResponseEntity<Void> createStudentBatch(@RequestBody StudentBatch studentBatch){
	//	System.out.println(studentBatch);
		StudentBatch createdStudentBatch = studentBatchService.createStudentBatch(studentBatch);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdStudentBatch.getSbId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/studentBatch/formEdit/{studentBatchId}")
	public ResponseEntity<StudentBatch> editStudentBatch(@PathVariable long studentBatchId, @RequestBody StudentBatch studentBatch){
		StudentBatch studentBatchEdited = studentBatchService.createStudentBatch(studentBatch);
		return new ResponseEntity<StudentBatch>(studentBatchEdited, HttpStatus.OK);
	}
}
