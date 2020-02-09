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

import com.vedisoft.vedisoft2020.pojos.Branch;
import com.vedisoft.vedisoft2020.services.IBranchService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class BranchesController {

	@Autowired
	private IBranchService branchService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/branches")
	public ResponseEntity<List<Branch>> getAllBranches() {
		System.out.println("inside branches");
		List<Branch> list = branchService.getAllBranches();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Branch>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable("id") Long id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Branch branch = branchService.getBranchById(id);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/branch/formSubmit")
	public ResponseEntity<Void> createBranch(@RequestBody Branch branch){
		Branch createdBranch = branchService.createBranch(branch);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBranch.getBranchId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/branch/formEdit/{branchId}")
	public ResponseEntity<Branch> editBranch(@PathVariable long branchId, @RequestBody Branch branch){
		Branch branchEdited = branchService.createBranch(branch);
		return new ResponseEntity<Branch>(branchEdited, HttpStatus.OK);
	}
	
}
