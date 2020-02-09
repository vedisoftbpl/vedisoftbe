package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IBranchDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Branch;
@Service
public class BranchService implements IBranchService {
	
	@Autowired
	private IBranchDetailsDao branchDetailDao;
	
	@Override
	public List<Branch> getAllBranches() {
		return branchDetailDao.getAllBranches();
	}

	@Override
	public Branch getBranchById(Long id) {
		return branchDetailDao.getBranchById(id);
	}
	
	@Override
	public Branch createBranch(Branch branch) {
		return branchDetailDao.createBranch(branch);
		
	}

	

}
