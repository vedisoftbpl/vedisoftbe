package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.jparepository.FeesJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Fee;

@Repository
@Transactional
public class FeesDetailsDao implements IFeesDetailsDao {
	
	@Autowired
	private FeesJpaRepository feeJpaRepository;
	
	@Override
	public List<Fee> getAllFees() {
		// TODO Auto-generated method stub
		return feeJpaRepository.findAll();
	}

	@Override
	public Fee getFeeById(int id) {
		// TODO Auto-generated method stub
		return feeJpaRepository.findById(id).get();
	}

	@Override
	public Fee createFee(Fee fee) {
		// TODO Auto-generated method stub
		if(fee.getId()==-1) {
			fee.setId(0);
		}
		return feeJpaRepository.save(fee);
	}

	@Override
	public Fee removeFee(int id) {
		// TODO Auto-generated method stub
		Fee fee = getFeeById(id);
		feeJpaRepository.deleteById(id);
		return fee;
	}

}
