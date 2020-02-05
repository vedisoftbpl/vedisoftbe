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
	public Branch saveBranch(Branch branch) {
		// TODO Auto-generated method stub
		int id = branch.getBranchId();
		if(id==-1) {
			return branchDetailDao.addNewBranch(branch);
		}
		else {
			return branchDetailDao.updateBranchById(branch);
		}
	}

	@Override
	public List<Branch> getAllBranches() {
		// TODO Auto-generated method stub
		return branchDetailDao.getAllBranches();
	}

	@Override
	public Branch getBranchById(int id) {
		// TODO Auto-generated method stub
		return branchDetailDao.getBranchById(id);
	}

}
