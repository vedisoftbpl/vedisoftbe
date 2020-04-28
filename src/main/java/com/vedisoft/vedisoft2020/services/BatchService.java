package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IBatchDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Batch;
@Service
public class BatchService implements IBatchService {

	@Autowired
	private IBatchDetailsDao iBatchDetailsDao;
	
	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return iBatchDetailsDao.getAllBatches();
	}

	@Override
	public Batch getBatchById(Long id) {
		// TODO Auto-generated method stub
		return iBatchDetailsDao.getBatchById(id);
	}

	@Override
	public Batch createBatch(Batch batch) {
		// TODO Auto-generated method stub
		return iBatchDetailsDao.createBatch(batch);
	}

	@Override
	public Batch removeBatch(Long id) {
		// TODO Auto-generated method stub
		return iBatchDetailsDao.removeBatchById(id);
	}

}
