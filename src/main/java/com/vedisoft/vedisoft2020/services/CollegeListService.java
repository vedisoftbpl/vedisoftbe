package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.ICollegeListDetailsDao;
import com.vedisoft.vedisoft2020.pojos.CollegeList;

@Service
public class CollegeListService implements ICollegeListService {

	@Autowired
	private ICollegeListDetailsDao collegeListDetailsDao;
	
	@Override
	public List<CollegeList> getAllCollegeList() {
		// TODO Auto-generated method stub
		return collegeListDetailsDao.getAllCollegeList();
	}

	@Override
	public CollegeList getCollegeById(Long collegeId) {
		// TODO Auto-generated method stub
		return collegeListDetailsDao.getCollegeById(collegeId);
	}

	@Override
	public CollegeList createCollegeList(CollegeList collegeList) {
		// TODO Auto-generated method stub
		return collegeListDetailsDao.createCollegeList(collegeList);
	}

}
