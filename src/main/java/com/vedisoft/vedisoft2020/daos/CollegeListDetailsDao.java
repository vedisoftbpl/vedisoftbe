package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.jparepository.CollegeListJpaRepository;
import com.vedisoft.vedisoft2020.pojos.CollegeList;

@Repository
@Transactional
public class CollegeListDetailsDao implements ICollegeListDetailsDao {

	@Autowired
	private CollegeListJpaRepository collegeListJpaRepository;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<CollegeList> getAllCollegeList() {
		// TODO Auto-generated method stub
		return collegeListJpaRepository.findAll();
	}

	@Override
	public CollegeList getCollegeById(Long collegeId) {
		// TODO Auto-generated method stub
		return collegeListJpaRepository.findById(collegeId).get();
	}

	@Override
	public CollegeList createCollegeList(CollegeList collegeList) {
		// TODO Auto-generated method stub
		System.out.println(collegeList);
		if(collegeList.getId()==-1) {
			collegeList.setId((long)0);
		}
		System.out.println(collegeList);
//		entityManager.persist(collegeList);
		return collegeListJpaRepository.save(collegeList);
//		return collegeList;
	}
	
}
