package com.vedisoft.vedisoft2020.controllers;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vedisoft.vedisoft2020.pojos.Student;
import com.vedisoft.vedisoft2020.services.IStudentService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vedisoft")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	
//	@Autowired
//	private BranchJpaRepository branchJpaRepository;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		System.out.println("inside student");
		List<Student> list = studentService.getAllStudents();
//		List<Branch> list = branchJpaRepository.findAll();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
//		Branch branch = branchJpaRepository.findById(id).get();
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	@GetMapping("/student/getImage/{imageName}")
	public ResponseEntity<List<String>> getImage(@PathVariable("imageName") String imageName){
		List<String> list ;
		list= studentService.loadImages(imageName);
		//System.out.println("Image Bytes = "+image);
		
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	
	//for adding the new branch
	@PostMapping("/student/formSubmit")
	public ResponseEntity<Void> createStudent(@RequestParam("myFile") MultipartFile file,
			@RequestParam("student") String student){
		String imgName = saveUploadedFile(file);
		Student st = new Student();
		try {
			st = new ObjectMapper().readValue(student, Student.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.setImg(imgName);
		Student createdStudent = studentService.createStudent(st);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdStudent.getRegistrationId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	public String saveUploadedFile(MultipartFile file) {
		String filename = new String();
		if (file.isEmpty()) {
			System.out.println("Empty");
			return "Emplty File";
		}
		try {
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			filename = file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - 4) + timeStamp
					+ ".jpg";
			String folder = "/photos/";
			byte[] bytes = file.getBytes();

			Path path = Paths.get(folder + filename);
			Files.write(path, bytes);
			System.out.println("Upload completed");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return filename;
	}
	
	//for editing the existing branch
	@PutMapping("/student/formEdit/{studentId}")
	public ResponseEntity<Student> editStudent(@PathVariable long studentId, @RequestBody Student student){
		Student studentEdited = studentService.createStudent(student);
		return new ResponseEntity<Student>(studentEdited, HttpStatus.OK);
	}
	
	@PostMapping("/student/collegeWise/{branchId}")
	public ResponseEntity<List<?>> getStudentsByCollege(@PathVariable int branchId, @RequestBody List<Date> dates) {
		Date startDate, endDate;
		startDate = dates.get(0);
		endDate = dates.get(1);
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String from = outputFormatter.format(startDate);
		String to = outputFormatter.format(endDate);
		List<?> studentsCollegeWise = studentService.getStudentsByCollege(from, to, branchId);
		return new ResponseEntity<List<?>>(studentsCollegeWise, HttpStatus.OK);
	}
}
