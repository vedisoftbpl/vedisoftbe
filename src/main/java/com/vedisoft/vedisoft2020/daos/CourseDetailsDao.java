package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.jparepository.CourseJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Course;

@Repository
@Transactional
public class CourseDetailsDao implements ICourseDetailsDao {

	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseJpaRepository.findAll();
	}

	@Override
	public Course getCourseById(Long courseId) {
		// TODO Auto-generated method stub
		return courseJpaRepository.findById(courseId).get();
	}

	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		if(course.getId() == -1) {
			Long i = (long)0;
			course.setId(i);
		}
		return courseJpaRepository.save(course);
	}

	@Override
	public Long removeCourseById(Long courseId) {
		// TODO Auto-generated method stub
		courseJpaRepository.deleteById(courseId);
		return courseId;
	}

}
