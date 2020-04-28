package com.vedisoft.vedisoft2020.Test;

import java.util.List;

import com.vedisoft.vedisoft2020.daos.CourseDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Course;

public class TrailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseDetailsDao c = new CourseDetailsDao();
		List<Course> course = c.getAllCourse();
		System.out.println(course.size());

	}

}
