package com.vedisoft.vedisoft2020.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.Batch;

@Repository
public interface BatchJpaRepository extends JpaRepository<Batch , Long>  {

}
