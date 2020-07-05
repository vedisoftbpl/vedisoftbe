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

	@Override
	public List<Installment> getByBranchId(long branchId) {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.getByBranchId(branchId);
	}

	@Override
	public List<Float> getTotalGST(String dateFrom, String dateTo) {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.getTotalGST(dateFrom, dateTo);
	}

	@Override
	public List<?> getDayBook(String date, int branchId) {
		return iInstallmentDetailsDao.getDayBook(date, branchId);
	}

	@Override
	public List<?> getBatchWiseCollection(int batchId) {

		return iInstallmentDetailsDao.getBatchWiseCollection(batchId);
	}

	@Override
	public List<?> getSessionWiseCollection(int sessionId) {
		return iInstallmentDetailsDao.getSessionWiseCollection(sessionId);
	}

	@Override
	public List<?> getBranchWiseCollection(String from, String to) {
		return iInstallmentDetailsDao.getBranchWiseCollection(from, to);
	}

	@Override
	public List<?> getFacultyWiseCollection(String from, String to) {
		return iInstallmentDetailsDao.getFacultyWiseCollection(from, to);
	}

	@Override
	public List<?> getCourseWiseCollection(List<Long> branches, String from, String to) {
		return iInstallmentDetailsDao.getCourseWiseCollection(branches, from, to);
	}

	@Override
	public List<?> getBranchWiseStudents(List<Long> branches, String from, String to) {
		return iInstallmentDetailsDao.getBranchWiseStudents(branches, from, to);
	}

	@Override
	public List<?> getBadDebts(List<Long> branches, String from, String to) {
		return iInstallmentDetailsDao.getBadDebts(branches, from, to);
	}

	@Override
	public List<?> getTotalBalance(int regNo, int batchId) {
		// TODO Auto-generated method stub
		return iInstallmentDetailsDao.getBalance(regNo, batchId);
	}

}
