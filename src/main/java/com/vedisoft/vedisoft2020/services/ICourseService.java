package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Course;

public interface ICourseService {
	List<Course> getAllCourse();
	Course getCourseById(Long courseId);
	Course createCourse(Course course);
	Long removeCourseById(Long courseId);
}
