package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.jparepository.BatchJpaRepository;
import com.vedisoft.vedisoft2020.pojos.Batch;
import com.vedisoft.vedisoft2020.pojos.Branch;
import com.vedisoft.vedisoft2020.pojos.Course;

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
		System.out.println(batch.getBranch().getBranchId());
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

//	@Override
//	public Batch trail() {
//		// TODO Auto-generated method stub
//		Course course = new CourseDetailsDao().getCourseById((long)1);
//		Batch batch = new Batch((long)0,(long)0,"2019",course);
//		
//		System.out.println(course.getId());
//		batchJpaRepository.save(batch);
//		return batch;
//	}


}
