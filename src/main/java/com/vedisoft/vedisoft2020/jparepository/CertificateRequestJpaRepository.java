package com.vedisoft.vedisoft2020.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedisoft.vedisoft2020.pojos.CertificateRequest;

@Repository
public interface CertificateRequestJpaRepository extends JpaRepository<CertificateRequest, Integer>{

}
