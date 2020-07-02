package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.core.io.Resource;

import com.vedisoft.vedisoft2020.pojos.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	Student getStudentById(int id);
	Student createStudent(Student student);
	Student removeStudent(int id);
	List<?> getStudentsByCollege(String startDate, String endDate, int branchId);
	List<String> loadImages(String filename);
}
