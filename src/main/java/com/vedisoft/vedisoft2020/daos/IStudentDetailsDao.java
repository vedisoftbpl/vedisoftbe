package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.core.io.Resource;

import com.vedisoft.vedisoft2020.pojos.Student;

public interface IStudentDetailsDao {
	List<Student> getAllStudents();
	Student getStudentById(int id);
	Student createStudent(Student student);
	Student removeStudent(int id);
	List<?> getStudentsByCollege(String startDate, String endDate, int branchId);
	List<String> loadImage(String filename);

}
