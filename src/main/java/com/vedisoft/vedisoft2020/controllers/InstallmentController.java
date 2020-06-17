package com.vedisoft.vedisoft2020.controllers;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.vedisoft.vedisoft2020.daos.BatchDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Batch;
import com.vedisoft.vedisoft2020.pojos.Branch;
import com.vedisoft.vedisoft2020.pojos.Installment;
import com.vedisoft.vedisoft2020.services.IBranchService;
import com.vedisoft.vedisoft2020.services.IInstallmentService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class InstallmentController {
	@Autowired
	private IInstallmentService installmentService;
	@Autowired
	private IBranchService branchService;
	@Autowired
	private BatchDetailsDao batchDetails;
	
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
		Batch batch =  batchDetails.getBatchById(installment.getBatch().getBatchId());
		installment.setBranch(batch.getBranch());
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
	public ResponseEntity<List<?>> getBatchWiseCollection(@PathVariable int batchId) {
		List<?> batchWiseCollection = installmentService.getBatchWiseCollection(batchId);
		return new ResponseEntity<List<?>>(batchWiseCollection, HttpStatus.OK);
	}
	@GetMapping("reports/sessionWiseCollection/{sessionId}")
	public ResponseEntity<List<?>> getSessionWiseCollection(@PathVariable int sessionId) {
		List<?> sessionWiseCollection = installmentService.getSessionWiseCollection(sessionId);
		return new ResponseEntity<List<?>>(sessionWiseCollection, HttpStatus.OK);
	}
	@PostMapping("reports/branchWiseCollection")
	public ResponseEntity<List<?>> getBranchWiseCollection(@RequestBody List<Date> date) {
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String from = outputFormatter.format(date.get(0));
		String to = outputFormatter.format(date.get(1));
		List<?> branchWiseCollection = installmentService.getBranchWiseCollection(from, to);
		return new ResponseEntity<List<?>>(branchWiseCollection, HttpStatus.OK);
	}
	@PostMapping("reports/facultyWiseCollection")
	public ResponseEntity<List<?>> getFacultyWiseCollection(@RequestBody List<Date> date) {
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String from = outputFormatter.format(date.get(0));
		String to = outputFormatter.format(date.get(1));
		List<?> facultyWiseCollection = installmentService.getFacultyWiseCollection(from, to);
		return new ResponseEntity<List<?>>(facultyWiseCollection, HttpStatus.OK);
	}
	@PostMapping("reports/courseWiseCollection/{branchId}")
	public ResponseEntity<List<?>> getCourseWiseCollection(@PathVariable Long branchId, @RequestBody List<Date> date) {
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		List<Long> branchIds = new ArrayList<Long>();
		List<Branch> branches = new ArrayList<Branch>();
		branches = branchService.getAllBranches();
		String from = outputFormatter.format(date.get(0));
		String to = outputFormatter.format(date.get(1));
		if(branchId == 0) {
			for(int i = 0; i < branches.size(); i++)
				branchIds.add(branches.get(i).getBranchId());
		}
		else {
			branchIds.add(branchId);
		}
			
		List<?> courseWiseCollection = installmentService.getCourseWiseCollection(branchIds, from, to);
		return new ResponseEntity<List<?>>(courseWiseCollection, HttpStatus.OK);
	}
	@PostMapping("reports/branchWiseStudents/{branchId}")
	public ResponseEntity<List<?>> getBranchWiseStudents(@PathVariable Long branchId, @RequestBody List<Date> date) {
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		List<Long> branchIds = new ArrayList<Long>();
		List<Branch> branches = new ArrayList<Branch>();
		branches = branchService.getAllBranches();
		String from = outputFormatter.format(date.get(0));
		String to = outputFormatter.format(date.get(1));
		if(branchId == 0) {
			for(int i = 0; i < branches.size(); i++)
				branchIds.add(branches.get(i).getBranchId());
		}
		else {
			branchIds.add(branchId);
		}
		List<?> branchWiseStudents = installmentService.getBranchWiseStudents(branchIds, from, to);
		return new ResponseEntity<List<?>>(branchWiseStudents, HttpStatus.OK);
	}
}
