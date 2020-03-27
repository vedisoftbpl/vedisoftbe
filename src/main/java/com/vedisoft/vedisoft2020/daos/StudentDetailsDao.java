package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.jparepository.StudentJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Student;

@Repository
@Transactional
public class StudentDetailsDao implements IStudentDetailsDao {
	
	@Autowired
	private StudentJpaRepository studentJpaRepository;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentJpaRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentJpaRepository.findById(id).get();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		if(student.getRegistrationId()==-1) {
			student.setRegistrationId(0);
		}
		return studentJpaRepository.save(student);
	}

	@Override
	public Student removeStudent(int id) {
		// TODO Auto-generated method stub
		Student student = getStudentById(id);
		studentJpaRepository.deleteById(id);
		return student;
	}

}
