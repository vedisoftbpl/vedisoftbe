package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Branch;

public interface IBranchService {
	
	Branch createBranch(Branch branch);
	Branch getBranchById(Long id);
	List<Branch> getAllBranches();
}
