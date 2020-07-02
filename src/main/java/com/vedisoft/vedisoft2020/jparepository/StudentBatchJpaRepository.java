package com.vedisoft.vedisoft2020.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.StudentBatch;

@Repository
public interface StudentBatchJpaRepository extends JpaRepository<StudentBatch, Long> {
	List<StudentBatch> findStudentBatchByBatchBatchId(long batchId);
}
