package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Course;

public interface ICourseDetailsDao {
	List<Course> getAllCourse();
	Course getCourseById(Long courseId);
	Course createCourse(Course course);
	Long removeCourseById(Long courseId);
}
