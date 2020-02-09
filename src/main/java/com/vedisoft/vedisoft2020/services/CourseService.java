package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.ICourseDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Course;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private ICourseDetailsDao courseDetailsDao;
	
	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseDetailsDao.getAllCourse();
	}

	@Override
	public Course getCourseById(Long courseId) {
		// TODO Auto-generated method stub
		return courseDetailsDao.getCourseById(courseId);
	}

	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDetailsDao.createCourse(course);
	}

	@Override
	public Long removeCourseById(Long courseId) {
		// TODO Auto-generated method stub
		return courseDetailsDao.removeCourseById(courseId);
	}

}
