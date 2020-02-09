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

import com.vedisoft.vedisoft2020.pojos.Session;
import com.vedisoft.vedisoft2020.services.ISessionService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class SessionsController {
	
	@Autowired
	private ISessionService sessionService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/sessions")
	public ResponseEntity<List<Session>> getAllSessions() {
		System.out.println("inside session");
		List<Session> list = sessionService.getAllSessions();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Session>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/session/{id}")
	public ResponseEntity<Session> getSessionById(@PathVariable("id") Long id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Session session = sessionService.getSessionById(id);
		return new ResponseEntity<Session>(session, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/session/formSubmit")
	public ResponseEntity<Void> createSession(@RequestBody Session session){
		Session createdSession = sessionService.createSession(session);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSession.getSessionId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//for editing the existing branch
	@PutMapping("/session/formEdit/{sessionId}")
	public ResponseEntity<Session> editSession(@PathVariable long sessionId, @RequestBody Session session){
		Session sessionEdited = sessionService.createSession(session);
		return new ResponseEntity<Session>(sessionEdited, HttpStatus.OK);
	}
}
