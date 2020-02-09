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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vedisoft.vedisoft2020.pojos.CollegeList;
import com.vedisoft.vedisoft2020.services.ICollegeListService;

@Controller
@CrossOrigin(origins="http://localhost:4200")	
@RequestMapping("vedisoft")
public class CollegeListController {
	
	@Autowired
	private ICollegeListService collegeListService;
	
	@GetMapping("/colleges")
	public ResponseEntity<List<CollegeList>> getAllCollegeList() {
		System.out.println("inside colleges");
		List<CollegeList> list = collegeListService.getAllCollegeList();
		return new ResponseEntity<List<CollegeList>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/college/{id}")
	public ResponseEntity<CollegeList> getCollegeById(@PathVariable("id") Long id) {
		CollegeList collegeList = collegeListService.getCollegeById(id);
		return new ResponseEntity<CollegeList>(collegeList, HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/college/formSubmit")
	public ResponseEntity<Void> createCollege(@RequestBody CollegeList collegeList){
		CollegeList createdCollegeList = collegeListService.createCollegeList(collegeList);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCollegeList.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
