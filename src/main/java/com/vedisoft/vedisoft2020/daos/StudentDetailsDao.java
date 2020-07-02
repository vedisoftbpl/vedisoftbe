package com.vedisoft.vedisoft2020.daos;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
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

	@Override
	public List<?> getStudentsByCollege(String startDate, String endDate, int branchId) {
		return studentJpaRepository.getStudentsByCollege(startDate, endDate, branchId);
	}
	
	@Override
	public List<String> loadImage(String filename) {
		String out = null;
		List<String> images = new ArrayList<>();
		File file = new File("/photos/"+filename);
		if(!file.isDirectory()) {
			String encodeBase64 = null;
			try {
				String  extension = FilenameUtils.getExtension(file.getName());
				FileInputStream fis = new FileInputStream(file);
				byte[] bytes = new byte[(int)file.length()];
				fis.read(bytes);
				encodeBase64 = Base64.getEncoder().encodeToString(bytes);
				out = "data:image/"+extension+";base64,"+encodeBase64;
//				out = encodeBase64;
				images.add(out);
						
				fis.close();
		    } catch (Exception e) {
		      throw new RuntimeException("FAIL!");
		    }
	
		}
		return images;
		}
	
}
