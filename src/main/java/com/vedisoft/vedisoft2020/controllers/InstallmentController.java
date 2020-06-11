package com.vedisoft.vedisoft2020.controllers;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
	@PostMapping("/installment/formSubmit")
	public ResponseEntity<Void> createInstallment(@RequestBody Installment installment){
		Installment createdInstallment = installmentService.createInstallment(installment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdInstallment.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/installment/formEdit/{installmentId}")
	public ResponseEntity<Installment> editInstallment(@PathVariable long installmentId, @RequestBody Installment installment){
		Installment installmentEdited = installmentService.createInstallment(installment);
		return new ResponseEntity<Installment>(installmentEdited, HttpStatus.OK);
	}
	@GetMapping("/installment/branch/{id}")
	public ResponseEntity<List<Installment>> getInstallmentById(@PathVariable("id") long id) {
		List<Installment> installment = installmentService.getByBranchId(id);
		return new ResponseEntity<List<Installment>>(installment, HttpStatus.OK);
	}
	@PostMapping("/reports/gst")
	public ResponseEntity<List<Float>> getTotalGST(@RequestBody List<Date> dates) {
		Date dateFrom, dateTo;
		dateFrom = dates.get(0);
		dateTo = dates.get(1);
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String from = outputFormatter.format(dateFrom);
		String to = outputFormatter.format(dateTo);
		System.out.println(dateTo + " " + dateFrom);
		System.out.println(to + " " + from);
		List<Float> gst = installmentService.getTotalGST(from, to);
		return new ResponseEntity<List<Float>>(gst, HttpStatus.OK);
//		return new ResponseEntity<Date>(new Date(), HttpStatus.OK);
	}
	@PostMapping("reports/daybook/{branchId}")
	public ResponseEntity<List<?>> getDayBook(@PathVariable int branchId, @RequestBody List<Date> date) {
	
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String dt = outputFormatter.format(date.get(0));
		List<?> dayBook = installmentService.getDayBook(dt, branchId);
		return new ResponseEntity<List<?>>(dayBook, HttpStatus.OK);
	}
	@GetMapping("reports/batchWiseCollection/{batchId}")
	public ResponseEntity<List<?>> getDayBook(@PathVariable int batchId) {
		List<?> batchWiseCollection = installmentService.getBatchWiseCollection(batchId);
		return new ResponseEntity<List<?>>(batchWiseCollection, HttpStatus.OK);
	}
}
