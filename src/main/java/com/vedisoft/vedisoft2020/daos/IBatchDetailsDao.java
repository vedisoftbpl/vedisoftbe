package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.Batch;

@Repository
public interface IBatchDetailsDao {
	
	List<Batch> getAllBatches();
	Batch getBatchById(Long id);
	Batch createBatch(Batch batch);
	Batch removeBatchById(Long id);
	Batch trail();
	
}
