package com.vedisoft.vedisoft2020.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.Branch;

@Repository
public interface BranchJpaRepository extends JpaRepository<Branch, Long> {
//	List<Branch> findAllBranches();
//	Branch findBranchById(int d);
//	Branch removeBranchById(int id);
//	Branch addNewBranch(Branch branch);
//	Branch updateBranchById(Branch branch);
}
