package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Branch;

public interface IBranchService {
	Branch saveBranch(Branch branch);
	List<Branch> getAllBranches();
	Branch getBranchById(int id);
}
