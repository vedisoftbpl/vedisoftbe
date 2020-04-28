package com.vedisoft.vedisoft2020;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vedisoft.vedisoft2020.daos.CourseDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Course;

public class BCryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		for(int i = 0; i<=10; i++) {
//			String encodedString = encoder.encode("7389330515") ;
//			System.out.println(encodedString) ;
//		}
		CourseDetailsDao c = new CourseDetailsDao();
		List<Course> course = c.getAllCourse();
		System.out.println(course.size());
	}

}
