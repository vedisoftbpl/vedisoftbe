package com.vedisoft.vedisoft2020.services;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.StudentBatch;

public interface IStudentBatchService {
	List<StudentBatch> getAllStudentBatch();
	StudentBatch getStudentBatchById(int studentBatchId);
	StudentBatch createStudentBatch(StudentBatch studentBatch);
	StudentBatch removeStudentBatchById(int studentBatchId);
	List<StudentBatch> getStudentBatchByStudentId(String studentId);
}
