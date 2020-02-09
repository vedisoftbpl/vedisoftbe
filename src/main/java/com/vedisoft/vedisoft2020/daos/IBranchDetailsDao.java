package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.Branch;

@Repository
public interface IBranchDetailsDao {
	
	List<Branch> getAllBranches();
	Branch getBranchById(Long id);
	Branch createBranch(Branch branch);
//	Branch removeBranchById(int id);
//	Branch addNewBranch(Branch branch);
//	Branch updateBranchById(Branch branch);
}
