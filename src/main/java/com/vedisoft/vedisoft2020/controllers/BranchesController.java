package com.vedisoft.vedisoft2020.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vedisoft.vedisoft2020.pojos.Branch;
import com.vedisoft.vedisoft2020.services.IBranchService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class BranchesController {
	@Autowired
	private IBranchService branchService;
	
	@GetMapping("/branches")
	public ResponseEntity<List<Branch>> getAllBranches() {
		System.out.println("inside branches");
		List<Branch> list = branchService.getAllBranches();
		return new ResponseEntity<List<Branch>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable("id") Integer id) {
		Branch branch = branchService.getBranchById(id);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
	
	@PostMapping("/branch/formSubmit")
	public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch){
		Branch br = branchService.saveBranch(branch);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
		
	}
	
	
	
}
