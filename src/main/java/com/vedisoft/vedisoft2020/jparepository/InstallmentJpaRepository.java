package com.vedisoft.vedisoft2020.jparepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.vedisoft.vedisoft2020.pojos.Installment;

@Repository
public interface InstallmentJpaRepository extends JpaRepository<Installment, Integer> {
	List<Installment> findInstallmentByBranchBranchId(long branchId);
	
	@Query(value = "SELECT SUM(i.sgst) "
			+ 
            "FROM Installment i " +
            "WHERE i.inst_date BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
	Float getSGST(@Param("dateFrom")String dateFrom, @Param("dateTo")String dateTo);
	
	@Query(value = "SELECT SUM(i.cgst) "
			+ 
            "FROM Installment i " +
            "WHERE i.inst_date BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
	Float getCGST(@Param("dateFrom")String dateFrom, @Param("dateTo")String dateTo);
	
	@Query(value = "SELECT name, reg_no, course, batch_id, mode1, staff_id, amt "
			+ 
            "FROM Installment INNER JOIN Student " +
			"ON Installment.reg_no = Student.registration_id " +
            "WHERE inst_date = :date AND Installment.branch_id = :branchId", nativeQuery = true)
	List<?> getDayBook(@Param("date")String date, @Param("branchId")int branchId);
	
	@Query(value = "SELECT name, reg_no, mno, amt "
			+ 
            "FROM Installment INNER JOIN Student " +
			"ON Installment.reg_no = Student.registration_id " +
            "WHERE Installment.batch_id = :batchId", nativeQuery = true)
	List<?> getBatchWiseCollection(@Param("batchId")int batchId);
	
	@Query(value = "SELECT Installment.branch_id, (SELECT Branches.branch_name FROM Branches WHERE branch_id = Installment.branch_id), SUM(amt) "
			+ 
            "FROM Installment INNER JOIN Batch " +
			"ON Installment.batch_id = Batch.batch_id " +
            "WHERE Batch.session_id = :sessionId GROUP BY Installment.branch_id", nativeQuery = true)
	List<?> getSessionWiseCollection(@Param("sessionId")int sessionId);
	
	@Query(value = "SELECT Installment.branch_id, (SELECT Branches.branch_name FROM Branches WHERE branch_id = Installment.branch_id), SUM(amt) "
			+ 
            "FROM Installment " +
            "WHERE inst_date BETWEEN :from AND :to GROUP BY Installment.branch_id", nativeQuery = true)
	List<?> getBranchWiseCollection(@Param("from")String from, @Param("to")String to);
}
