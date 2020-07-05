package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.jparepository.BatchJpaRepository;
import com.vedisoft.vedisoft2020.jparepository.StudentBatchJpaRepository;
import com.vedisoft.vedisoft2020.pojos.StudentBatch;

@Repository
@Transactional
public class StudentBatchDetailsDao implements IStudentBatchDetailsDao {
	
	@Autowired
	private StudentBatchJpaRepository studentBatchJpaRepository;
	
//	@Autowired
//	private BatchDetailsDao batchDetails;
	
	@Override
	public List<StudentBatch> getAllStudentBatch() {
		// TODO Auto-generated method stub
		return studentBatchJpaRepository.findAll();
	}

	@Override
	public StudentBatch getStudentBatchById(long studentBatchId) {
		// TODO Auto-generated method stub
		return studentBatchJpaRepository.findById(studentBatchId).get();
	}

	@Override
	public StudentBatch createStudentBatch(StudentBatch studentBatch) {
		// TODO Auto-generated method stub
//		System.out.println(studentBatch);
//		studentBatch.setBatch(batchDetails.getBatchById(studentBatch.getBatch().getBatchId()));
		
		if(studentBatch.getSbId()==-1) {
			studentBatch.setSbId(0);
		}
		return studentBatchJpaRepository.save(studentBatch);
	}

	@Override
	public StudentBatch removeStudentBatchById(long studentBatchId) {
		// TODO Auto-generated method stub
		StudentBatch studentBatch = getStudentBatchById(studentBatchId);
		studentBatchJpaRepository.deleteById(studentBatchId);
		return studentBatch;
	}

	@Override
	public List<StudentBatch> getStudentBatchByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentBatchJpaRepository.findStudentBatchByStudentId(studentId);
	}

}
