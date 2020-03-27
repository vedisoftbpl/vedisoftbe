package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Fee;

public interface IFeesDetailsDao {
	List<Fee> getAllFees();
	Fee getFeeById(int id);
	Fee createFee(Fee fee);
	Fee removeFee(int id);
}
