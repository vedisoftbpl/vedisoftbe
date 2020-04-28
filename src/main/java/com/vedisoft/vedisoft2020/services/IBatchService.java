package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Batch;

public interface IBatchService {
	List<Batch> getAllBatches();
	Batch getBatchById(Long id);
	Batch createBatch(Batch batch);
	Batch removeBatch(Long id);
}
