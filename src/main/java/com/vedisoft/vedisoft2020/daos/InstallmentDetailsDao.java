package com.vedisoft.vedisoft2020.daos;

import java.util.ArrayList;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.jparepository.InstallmentJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Installment;

@Repository
@Transactional
public class InstallmentDetailsDao implements IInstallmentDetailsDao {
	
	@Autowired
	private InstallmentJpaRepository installmentJpaRepository;
	@Override
	public List<Installment> getAllInstallments() {
		// TODO Auto-generated method stub
		return installmentJpaRepository.findAll();
	}

	@Override
	public Installment getInstallmentById(int id) {
		// TODO Auto-generated method stub
		return installmentJpaRepository.findById(id).get();
	}

	@Override
	public Installment createInstallment(Installment installment) {
		// TODO Auto-generated method stub
		if(installment.getId()==-1) {
			installment.setId(0);
		}
		return installmentJpaRepository.save(installment);
	}

	@Override
	public Installment removeInstallment(int id) {
		// TODO Auto-generated method stub
		Installment installment = getInstallmentById(id);
		installmentJpaRepository.deleteById(id);
		return installment;
	}

	@Override
	public List<Installment> getByBranchId(long branchId) {

		return installmentJpaRepository.findInstallmentByBranchBranchId(branchId);
	}

	@Override
	public List<Float> getTotalGST(String dateFrom, String dateTo) {
		List<Float> totalGST = new ArrayList<Float>();
		totalGST.add(0, installmentJpaRepository.getCGST(dateFrom, dateTo));
		totalGST.add(1, installmentJpaRepository.getSGST(dateFrom, dateTo));
		return totalGST;
	}

	@Override
	public List<?> getDayBook(String date, int branchId) {
		return installmentJpaRepository.getDayBook(date, branchId);
	}

	@Override
	public List<?> getBatchWiseCollection(int batchId) {
		return installmentJpaRepository.getBatchWiseCollection(batchId);
	}

}
