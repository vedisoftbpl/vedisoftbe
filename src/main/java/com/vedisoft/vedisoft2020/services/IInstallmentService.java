package com.vedisoft.vedisoft2020.services;


import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Installment;

public interface IInstallmentService {
	List<Installment> getAllInstallments();
	Installment getInstallmentById(int id);
	Installment createInstallment(Installment installment);
	Installment removeInstallment(int id);
	List<Installment> getByBranchId(long branchId);
	List<Float> getTotalGST(String dateFrom, String dateTo);
	List<?> getDayBook(String date, int branchId);
}
