package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.CollegeList;

public interface ICollegeListDetailsDao {
	List<CollegeList> getAllCollegeList();
	CollegeList getCollegeById(Long collegeId);
	CollegeList createCollegeList(CollegeList collegeList);
}
