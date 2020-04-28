package com.vedisoft.vedisoft2020.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vedisoft.vedisoft2020.services.IPersonService;
import com.vedisoft.vedisoft2020.pojos.Person;


@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> list = personService.getAllPersons();
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person person = personService.getPersonById(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	

	@PostMapping("/person/formSubmit")
	public ResponseEntity<Void> createPerson(@RequestBody Person person){
		Person createdPerson = personService.createPerson(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPerson.getPersonId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@PutMapping("/person/formEdit/{personId}")
	public ResponseEntity<Person> editPerson(@PathVariable long personId, @RequestBody Person person){
		Person personEdited = personService.createPerson(person);
		return new ResponseEntity<Person>(personEdited, HttpStatus.OK);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable Long id){
		Person personDeleted = personService.getPersonById(id);
		personService.removePersonById(id);
		if (personDeleted != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
