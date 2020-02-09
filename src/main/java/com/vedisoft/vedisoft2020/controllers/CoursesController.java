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

import com.vedisoft.vedisoft2020.pojos.Course;
import com.vedisoft.vedisoft2020.services.ICourseService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class CoursesController {

	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		System.out.println("inside course");
		List<Course> list = courseService.getAllCourse();
		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
		Course course = courseService.getCourseById(id);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	
	@PostMapping("/course/formSubmit")
	public ResponseEntity<Void> createCourse(@RequestBody Course course){
		Course createdCourse = courseService.createCourse(course);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/course/formEdit/{courseId}")
	public ResponseEntity<Course> editCourse(@PathVariable long courseId, @RequestBody Course course){
		Course courseEdited = courseService.createCourse(course);
		return new ResponseEntity<Course>(courseEdited, HttpStatus.OK);
	}
	
	@DeleteMapping("/course/formDelete/{id}")
	public ResponseEntity<Void>  removeCourseById(@PathVariable long id){
		if(id == 0) {
			return ResponseEntity.notFound().build();
		}
		courseService.removeCourseById(id);
		return ResponseEntity.noContent().build();
	}
	
}
