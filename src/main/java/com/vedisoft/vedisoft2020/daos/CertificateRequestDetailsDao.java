package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedisoft.vedisoft2020.jparepository.CertificateRequestJpaRepository;
import com.vedisoft.vedisoft2020.pojos.CertificateRequest;

@Repository
@Transactional
public class CertificateRequestDetailsDao implements ICertificateRequestDetailsDao {
	
	@Autowired
	private CertificateRequestJpaRepository requestJpaRepository;
	
	@Override
	public List<CertificateRequest> getAllRequests() {
		// TODO Auto-generated method stub
		return requestJpaRepository.findAll();
	}

	@Override
	public CertificateRequest getRequestById(int id) {
		// TODO Auto-generated method stub
		return requestJpaRepository.findById(id).get();
	}

	@Override
	public CertificateRequest createRequest(CertificateRequest request) {
		// TODO Auto-generated method stub
		if(request.getId()==-1) {
			request.setId(0);
		}
		return requestJpaRepository.save(request);
	}

	@Override
	public CertificateRequest removeRequest(int id) {
		// TODO Auto-generated method stub
		CertificateRequest request = getRequestById(id);
		requestJpaRepository.deleteById(id);
		return request;
	}

}
