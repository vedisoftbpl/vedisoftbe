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

import com.vedisoft.vedisoft2020.pojos.CertificateRequest;
import com.vedisoft.vedisoft2020.services.ICertificateRequestService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class CertificateRequestController {
	@Autowired
	private ICertificateRequestService certificateRequestService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/certificateRequests")
	public ResponseEntity<List<CertificateRequest>> getAllCertificateRequests() {
		System.out.println("inside certificateRequest");
		List<CertificateRequest> list = certificateRequestService.getAllRequests();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<CertificateRequest>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/certificateRequest/{id}")
	public ResponseEntity<CertificateRequest> getCertificateRequestById(@PathVariable("id") int id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		CertificateRequest certificateRequest = certificateRequestService.getRequestById(id);
		return new ResponseEntity<CertificateRequest>(certificateRequest, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/certificateRequest/formSubmit")
	public ResponseEntity<Void> createCertificateRequest(@RequestBody CertificateRequest certificateRequest){
		CertificateRequest createdCertificateRequest = certificateRequestService.createRequest(certificateRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCertificateRequest.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/certificateRequest/formEdit/{certificateRequestId}")
	public ResponseEntity<CertificateRequest> editCertificateRequest(@PathVariable long certificateRequestId, @RequestBody CertificateRequest certificateRequest){
		CertificateRequest certificateRequestEdited = certificateRequestService.createRequest(certificateRequest);
		return new ResponseEntity<CertificateRequest>(certificateRequestEdited, HttpStatus.OK);
	}
}
