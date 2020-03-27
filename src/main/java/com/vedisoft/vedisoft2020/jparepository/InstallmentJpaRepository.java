package com.vedisoft.vedisoft2020.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.Installment;

@Repository
public interface InstallmentJpaRepository extends JpaRepository<Installment, Integer> {

}
