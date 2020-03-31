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

import com.vedisoft.vedisoft2020.pojos.Installment;
import com.vedisoft.vedisoft2020.services.IInstallmentService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class InstallmentController {
	@Autowired
	private IInstallmentService installmentService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/installments")
	public ResponseEntity<List<Installment>> getAllInstallments() {
		System.out.println("inside installment");
		List<Installment> list = installmentService.getAllInstallments();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Installment>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/installment/{id}")
	public ResponseEntity<Installment> getInstallmentById(@PathVariable("id") int id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Installment installment = installmentService.getInstallmentById(id);
		return new ResponseEntity<Installment>(installment, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/installment/formSubmit")
	public ResponseEntity<Void> createInstallment(@RequestBody Installment installment){
		Installment createdInstallment = installmentService.createInstallment(installment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdInstallment.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/installment/formEdit/{installmentId}")
	public ResponseEntity<Installment> editInstallment(@PathVariable long installmentId, @RequestBody Installment installment){
		Installment installmentEdited = installmentService.createInstallment(installment);
		return new ResponseEntity<Installment>(installmentEdited, HttpStatus.OK);
	}
}
