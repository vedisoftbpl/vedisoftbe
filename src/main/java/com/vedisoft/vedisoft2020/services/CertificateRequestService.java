package com.vedisoft.vedisoft2020.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.ICertificateRequestDetailsDao;
import com.vedisoft.vedisoft2020.pojos.CertificateRequest;
@Service
public class CertificateRequestService implements ICertificateRequestService {
	
	@Autowired
	private ICertificateRequestDetailsDao iCertificateRequestDetailsDao;
	
	@Override
	public List<CertificateRequest> getAllRequests() {
		// TODO Auto-generated method stub
		return iCertificateRequestDetailsDao.getAllRequests();
	}

	@Override
	public CertificateRequest getRequestById(int id) {
		// TODO Auto-generated method stub
		return iCertificateRequestDetailsDao.getRequestById(id);
	}

	@Override
	public CertificateRequest createRequest(CertificateRequest request) {
		// TODO Auto-generated method stub
		return iCertificateRequestDetailsDao.createRequest(request);
	}

	@Override
	public CertificateRequest removeRequest(int id) {
		// TODO Auto-generated method stub
		return iCertificateRequestDetailsDao.removeRequest(id);
	}

}
