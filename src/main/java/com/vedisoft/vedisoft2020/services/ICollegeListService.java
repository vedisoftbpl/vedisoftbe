package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.CollegeList;
import com.vedisoft.vedisoft2020.pojos.Course;

public interface ICollegeListService {
	List<CollegeList> getAllCollegeList();
	CollegeList getCollegeById(Long collegeId);
	CollegeList createCollegeList(CollegeList collegeList);
}
