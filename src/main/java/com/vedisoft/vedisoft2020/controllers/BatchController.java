package com.vedisoft.vedisoft2020.controllers;

import java.net.URI;
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

import com.vedisoft.vedisoft2020.daos.BranchDetailsDao;
import com.vedisoft.vedisoft2020.daos.CourseDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Batch;
import com.vedisoft.vedisoft2020.pojos.Branch;
import com.vedisoft.vedisoft2020.pojos.Course;
import com.vedisoft.vedisoft2020.pojos.Session;
import com.vedisoft.vedisoft2020.services.IBatchService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class BatchController {
	@Autowired
	private IBatchService batchService;
	
	@GetMapping("/batches")
	public ResponseEntity<List<Batch>> getAllBatches() {
		System.out.println("inside batch");
		List<Batch> list = batchService.getAllBatches();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Batch>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/batch/{id}")
	public ResponseEntity<Batch> getBatchById(@PathVariable("id") Long id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Batch batch = batchService.getBatchById(id);
		return new ResponseEntity<Batch>(batch, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/batch/formSubmit")
	public ResponseEntity<Void> createBatch(){
		Course course = new Course();
		course.setId((long)1);
		Session session = new Session();
		session.setSessionId((long)23);
//		branch.setBranchId((long)1);
//		branch.setExtra1("dsfs");
//		branch.setExtra2(4);
		System.out.println("intialized");
		Batch b = new Batch();
		b.setBatchId((long)0);
		b.setCode("gh");
		b.setCourse(course);
		b.setCreatedBy(1);
		b.setCreationDate(new Date());
		b.setDays("3");
		b.setEnddate(""+new Date()+"");
		b.setFacultyId(1);
		b.setLastUpdatedBy(1);
		b.setLastUpdationDate(new Date());
		b.setSdate(new Date());
		b.setSession(session);
		b.setStatus("dfghj");
		b.setTimings("5678");
		b.setBranchId((long)1);
//		b.setBranch(branch);
		Batch createdBatch = batchService.createBatch(b);
		System.out.println("added"); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBatch.getBatchId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/batch/formEdit/{batchId}")
	public ResponseEntity<Batch> editBatch(@PathVariable long batchId, @RequestBody Batch batch){
		Batch batchEdited = batchService.createBatch(batch);
		return new ResponseEntity<Batch>(batchEdited, HttpStatus.OK);
	}

}
