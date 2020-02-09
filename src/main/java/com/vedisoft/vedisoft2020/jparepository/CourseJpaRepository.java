package com.vedisoft.vedisoft2020.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedisoft.vedisoft2020.pojos.Course;

public interface CourseJpaRepository extends JpaRepository<Course,Long> {
	
}
