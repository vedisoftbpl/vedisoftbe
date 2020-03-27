package com.vedisoft.vedisoft2020.daos;

import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Installment;

public interface IInstallmentDetailsDao {
	List<Installment> getAllInstallments();
	Installment getInstallmentById(int id);
	Installment createInstallment(Installment installment);
	Installment removeInstallment(int id);
}
