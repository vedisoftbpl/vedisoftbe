package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Branch;

public interface IBranchDetailsDao {
	List<Branch> getAllBranches();
	Branch getBranchById(int id);
	Branch removeBranchById(int id);
	Branch addNewBranch(Branch branch);
	Branch updateBranchById(Branch branch);
}
