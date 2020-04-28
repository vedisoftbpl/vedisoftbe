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
import com.vedisoft.vedisoft2020.pojos.PersonType;
import com.vedisoft.vedisoft2020.services.IPersonTypeService;


@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class PersonTypeController {
	
	@Autowired
	private IPersonTypeService personTypeService;
	
	
	@GetMapping("/personTypes")
	public ResponseEntity<List<PersonType>> getAllPersonTypes() {
		List<PersonType> list = personTypeService.getAllPersonTypes();
		return new ResponseEntity<List<PersonType>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/personType/{id}")
	public ResponseEntity<PersonType> getPersonTypeById(@PathVariable Long id) {
		PersonType personType = personTypeService.getPersonTypeById(id);
		return new ResponseEntity<PersonType>(personType, HttpStatus.OK);
	}
	

	@PostMapping("/personType/formSubmit")
	public ResponseEntity<Void> createPerson(@RequestBody PersonType personType){
		PersonType createdPersonType = personTypeService.createPersonType(personType);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPersonType.getPersonTypeId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@PutMapping("/personType/formEdit/{personId}")
	public ResponseEntity<PersonType> editPerson(@PathVariable long personId, @RequestBody PersonType personType){
		PersonType personTypeEdited = personTypeService.createPersonType(personType);
		return new ResponseEntity<PersonType>(personTypeEdited, HttpStatus.OK);
	}
	
	@DeleteMapping("/personType/{id}")
	public ResponseEntity<PersonType> deletePerson(@PathVariable Long id){
		PersonType personTypeDeleted = personTypeService.getPersonTypeById(id);
		personTypeService.removePersonTypeById(id);
		if (personTypeDeleted != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}


}
