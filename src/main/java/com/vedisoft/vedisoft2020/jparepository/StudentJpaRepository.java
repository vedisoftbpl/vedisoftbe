package com.vedisoft.vedisoft2020.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
	
	@Query(value = "SELECT (SELECT c.name FROM college_list c WHERE c.id = s.college_id), COUNT(s.registration_id)  "
			+ 
            "FROM Student s " +
            "WHERE s.registration_date BETWEEN :startDate AND :endDate AND s.branch_id = :branchId GROUP BY college_id", nativeQuery = true)
	List<?> getStudentsByCollege(@Param("startDate")String startDate, @Param("endDate")String endDate, @Param("branchId") int branchId);

}
