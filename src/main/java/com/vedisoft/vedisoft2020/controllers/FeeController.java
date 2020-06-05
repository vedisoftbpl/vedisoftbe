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

import com.vedisoft.vedisoft2020.pojos.Fee;
import com.vedisoft.vedisoft2020.services.IFeeService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class FeeController {
	@Autowired
	private IFeeService feeService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/fees")
	public ResponseEntity<List<Fee>> getAllFees() {
		System.out.println("inside fee");
		List<Fee> list = feeService.getAllFees();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Fee>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/fee/{id}")
	public ResponseEntity<Fee> getFeeById(@PathVariable("id") int id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Fee fee = feeService.getFeeById(id);
		return new ResponseEntity<Fee>(fee, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/fee/formSubmit")
	public ResponseEntity<Void> createFee(@RequestBody Fee fee){
		Fee createdFee = feeService.createFee(fee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdFee.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/fee/formEdit/{feeId}")
	public ResponseEntity<Fee> editFee(@PathVariable long feeId, @RequestBody Fee fee){
		Fee feeEdited = feeService.createFee(fee);
		return new ResponseEntity<Fee>(feeEdited, HttpStatus.OK);
	}
	
//	@GetMapping("/fee/branch/{branchId}")
//	public ResponseEntity<List<Fee>> getByBranch(@PathVariable("branchId") int id) {
//		List<Fee> fee = feeService.getByBranch(id);
//		return new ResponseEntity<List<Fee>>(fee, HttpStatus.OK);
//	}
}
