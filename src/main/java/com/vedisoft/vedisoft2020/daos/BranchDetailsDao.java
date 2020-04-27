package com.vedisoft.vedisoft2020.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.jparepository.BranchJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Branch;

@Repository
@Transactional
public class BranchDetailsDao implements IBranchDetailsDao{
	
	
	@Autowired
	private BranchJpaRepository branchJpaRepository;
	
	
	@Override
	public List<Branch> getAllBranches() {
		return branchJpaRepository.findAll();
	}
	
	@Override
	public Branch getBranchById(Long id) {
		return branchJpaRepository.findById(id).get();
	}
	
	@Override
	public Branch createBranch(Branch branch) {
		branch.setBranchId(0L);
		return branchJpaRepository.save(branch);
	}

}
