package com.vedisoft.vedisoft2020.jparepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vedisoft.vedisoft2020.pojos.Fee;

@Repository
public interface FeesJpaRepository extends JpaRepository<Fee, Integer>{	
	List<Fee> findFeeByBranchBranchId(long branchId);
}
