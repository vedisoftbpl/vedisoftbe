package com.vedisoft.vedisoft2020.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.pojos.Branch;

@Repository
@Transactional
public class BranchDetailsDao implements IBranchDetailsDao {
	
	@PersistenceContext
	private EntityManager entityManager ;
	
	@Override
	public List<Branch> getAllBranches() {
		// TODO Auto-generated method stub
		String hql = "FROM Branch as branch ORDER By branch.branchId";
		return (List<Branch>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Branch updateBranchById(Branch branch) {
		// TODO Auto-generated method stub
		int id = branch.getBranchId();
		Branch br = getBranchById(id);
		br.setBranchName(branch.getBranchName());
		br.setBranchPrefix(branch.getBranchPrefix());
		br.setBranchContactNo(branch.getBranchContactNo());
		br.setBranchManagerId(branch.getBranchManagerId());
		br.setMultipleCourses(branch.getMultipleCourses());
		br.setPlotNo(branch.getPlotNo());
		br.setLocality(branch.getLocality());
		br.setStreet(branch.getStreet());
		br.setCity(branch.getCity());
		br.setState(branch.getState());
		br.setLat(branch.getLat());
		br.setLong_(branch.getLong_());
		entityManager.flush();
		return br;
	}

	@Override
	public Branch getBranchById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Branch.class, id);
	}

	@Override
	public Branch removeBranchById(int id) {
		// TODO Auto-generated method stub
		Branch branch = getBranchById(id);
		entityManager.remove(branch);
		return branch;
	}

	@Override
	public Branch addNewBranch(Branch branch) {
		// TODO Auto-generated method stub
		branch.setBranchId(0);
		entityManager.persist(branch);
		return branch;
	}

}
