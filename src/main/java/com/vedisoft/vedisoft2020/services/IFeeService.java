package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Fee;

public interface IFeeService {
	List<Fee> getAllFees();
	Fee getFeeById(int id);
	Fee createFee(Fee fee);
	Fee removeFee(int id);
	List<Fee> getByBranch(int branchId);
}
