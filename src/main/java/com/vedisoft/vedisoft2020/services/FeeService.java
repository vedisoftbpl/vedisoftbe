package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IFeesDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Fee;

@Service
public class FeeService implements IFeeService {
	
	@Autowired
	private IFeesDetailsDao iFeesDetailsDao; 
	
	@Override
	public List<Fee> getAllFees() {
		// TODO Auto-generated method stub
		return iFeesDetailsDao.getAllFees();
	}

	@Override
	public Fee getFeeById(int id) {
		// TODO Auto-generated method stub
		return iFeesDetailsDao.getFeeById(id);
	}

	@Override
	public Fee createFee(Fee fee) {
		// TODO Auto-generated method stub
		return iFeesDetailsDao.createFee(fee);
	}

	@Override
	public Fee removeFee(int id) {
		// TODO Auto-generated method stub
		return iFeesDetailsDao.removeFee(id);
	}

	@Override
	public List<Fee> getByBranch(int branchId) {
		return iFeesDetailsDao.getByBranch(branchId);
	}

	@Override
	public List<Fee> getByBatch(int batchId) {
		return iFeesDetailsDao.getByBatch(batchId);
	}

}
