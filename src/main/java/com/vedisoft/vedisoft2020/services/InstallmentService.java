package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IInstallmentDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Installment;

@Service
public class InstallmentService implements IInstallmentService {
	
	@Autowired
	private IInstallmentDetailsDao iInstallmentDetailsDao;
	
	@Override
	public List<Installment> getAllInstallments() {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.getAllInstallments();
	}

	@Override
	public Installment getInstallmentById(int id) {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.getInstallmentById(id);
	}

	@Override
	public Installment createInstallment(Installment installment) {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.createInstallment(installment);
	}

	@Override
	public Installment removeInstallment(int id) {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.removeInstallment(id);
	}

}
