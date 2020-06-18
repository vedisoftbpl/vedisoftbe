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
	
	@Query(value = "SELECT person_name, SUM(amt) " + 
            "FROM ((Installment INNER JOIN Batch ON Installment.batch_id = Batch.batch_id) " +
			"INNER JOIN Person ON Batch.faculty_id = Person.person_id) " +
            "WHERE inst_date BETWEEN :from AND :to GROUP BY Batch.faculty_id", nativeQuery = true)
	List<?> getFacultyWiseCollection(@Param("from")String from, @Param("to")String to);
	
	@Query(value = "SELECT Installment.branch_id, Course.name, SUM(amt) " + 
            "FROM ((Installment INNER JOIN Batch ON Installment.batch_id = Batch.batch_id) " +
			"INNER JOIN Course ON Batch.course_id = Course.id) " +
            "WHERE ((Installment.branch_id IN :branches) AND (inst_date BETWEEN :from AND :to)) GROUP BY Batch.course_id", nativeQuery = true)
	List<?> getCourseWiseCollection(@Param("branches")List<Long> branches, @Param("from")String from, @Param("to")String to);
	
	@Query(value = "SELECT student_batch.batch_id, COUNT(sb_id) " +
			"FROM student_batch INNER JOIN Student ON student_batch.student_id = Student.registration_id  " +
            "WHERE ((Student.branch_id IN :branches) AND (registration_date BETWEEN :from AND :to)) GROUP BY student_batch.batch_id", nativeQuery = true)
	List<?> getBranchWiseStudents(@Param("branches")List<Long> branches, @Param("from")String from, @Param("to")String to);
	
	@Query(value = "SELECT student_batch.batch_id, ((SELECT COUNT(student_batch.sb_id) * (fees.famt) " + 
			"FROM student_batch WHERE student_batch.batch_id = Fees.batch_id)  - (SELECT SUM(Installment.amt) " + 
			"FROM Installment WHERE Installment.batch_id = Fees.batch_id)), Installment.branch_id " + 
            "FROM ((Fees INNER JOIN student_batch ON Fees.batch_id = student_batch.batch_id) " +
			"INNER JOIN Installment ON student_batch.batch_id = Installment.batch_id) " +
            "WHERE ((Installment.branch_id IN :branches) AND (due_date BETWEEN :from AND :to)) GROUP BY student_batch.batch_id", nativeQuery = true)
	List<?> getBadDebts(@Param("branches")List<Long> branches, @Param("from")String from, @Param("to")String to);
}
