package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IStudentBatchDetailsDao;
import com.vedisoft.vedisoft2020.pojos.StudentBatch;

@Service
public class StudentBatchService implements IStudentBatchService {
	
	@Autowired
	private IStudentBatchDetailsDao iStudentBatchDetailsDao;
	
	@Override
	public List<StudentBatch> getAllStudentBatch() {
		// TODO Auto-generated method stub
		return iStudentBatchDetailsDao.getAllStudentBatch();
	}

	@Override
	public StudentBatch getStudentBatchById(int studentBatchId) {
		// TODO Auto-generated method stub
		return iStudentBatchDetailsDao.getStudentBatchById(studentBatchId);
	}

	@Override
	public StudentBatch createStudentBatch(StudentBatch studentBatch) {
		// TODO Auto-generated method stub
		return iStudentBatchDetailsDao.createStudentBatch(studentBatch);
	}

	@Override
	public StudentBatch removeStudentBatchById(int studentBatchId) {
		// TODO Auto-generated method stub
		return iStudentBatchDetailsDao.removeStudentBatchById(studentBatchId);
	}

	@Override
	public List<StudentBatch> getStudentBatchByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return iStudentBatchDetailsDao.getStudentBatchByStudentId(studentId);
	}

}
