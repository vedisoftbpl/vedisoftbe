package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.CertificateRequest;

public interface ICertificateRequestDetailsDao {
	List<CertificateRequest> getAllRequests();
	CertificateRequest getRequestById(int id);
	CertificateRequest createRequest(CertificateRequest request);
	CertificateRequest removeRequest(int id);
}
