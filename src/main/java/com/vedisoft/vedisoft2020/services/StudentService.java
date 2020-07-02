package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IStudentDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Student;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDetailsDao iStudentDetailsDao;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return iStudentDetailsDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return iStudentDetailsDao.getStudentById(id);
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return iStudentDetailsDao.createStudent(student);
	}

	@Override
	public Student removeStudent(int id) {
		// TODO Auto-generated method stub
		return iStudentDetailsDao.removeStudent(id);
	}

	@Override
	public List<?> getStudentsByCollege(String startDate, String endDate, int branchId) {
		return iStudentDetailsDao.getStudentsByCollege(startDate, endDate, branchId);
	}

	@Override
	public List<String> loadImages(String filename) {
		// TODO Auto-generated method stub
		return iStudentDetailsDao.loadImage(filename);
	}

}
