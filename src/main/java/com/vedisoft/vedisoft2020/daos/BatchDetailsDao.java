package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.jparepository.BatchJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Batch;

@Repository
@Transactional
public class BatchDetailsDao implements IBatchDetailsDao {
	
	@Autowired
	private BatchJpaRepository batchJpaRepository;
	
	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return batchJpaRepository.findAll();
	}

	@Override
	public Batch getBatchById(Long id) {
		// TODO Auto-generated method stub
		return batchJpaRepository.findById(id).get();
	}

	@Override
	public Batch createBatch(Batch batch) {
		// TODO Auto-generated method stub
		if(batch.getBatchId()==-1) {
			batch.setBatchId((long)0);
		}
		return batchJpaRepository.save(batch);
	}

	@Override
	public Batch removeBatchById(Long id) {
		// TODO Auto-generated method stub
		Batch batch = getBatchById(id);
		batchJpaRepository.deleteById(id);
		return batch;
	}


}
