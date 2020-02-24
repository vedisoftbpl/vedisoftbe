package com.vedisoft.vedisoft2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vedisoft.vedisoft2020.pojos.Person;
import com.vedisoft.vedisoft2020.services.IUserDetailsService;


@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class UserDetailsController {
	
	@Autowired
	private IUserDetailsService userDetailsService;
	
	@GetMapping("/user/{username}")
	public ResponseEntity<Person> getSessionById(@PathVariable("username") String username) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Person person = userDetailsService.getActiveUserDetails(username);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

}
