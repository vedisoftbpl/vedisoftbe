package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.StudentBatch;

public interface IStudentBatchDetailsDao {
	List<StudentBatch> getAllStudentBatch();
	StudentBatch getStudentBatchById(long studentBatchId);
	StudentBatch createStudentBatch(StudentBatch studentBatch);
	StudentBatch removeStudentBatchById(long studentBatchId);
	List<StudentBatch> getStudentBatchByStudentId(String studentId);
}
