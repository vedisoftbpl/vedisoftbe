package com.vedisoft.vedisoft2020.daos;


import java.util.List;

import com.vedisoft.vedisoft2020.pojos.Installment;

public interface IInstallmentDetailsDao {
	List<Installment> getAllInstallments();
	Installment getInstallmentById(int id);
	Installment createInstallment(Installment installment);
	Installment removeInstallment(int id);
	List<Installment> getByBranchId(long branchId);
	List<Float> getTotalGST(String dateFrom, String dateTo);
	List<?> getBalance(int regNo, int batchId);
	List<?> getDayBook(String date, int branchId);
	List<?> getBatchWiseCollection(int batchId);
	List<?> getSessionWiseCollection(int sessionId);
	List<?> getBranchWiseCollection(String from, String to);
	List<?> getFacultyWiseCollection(String from, String to);
	List<?> getCourseWiseCollection(List<Long> branches, String from, String to);
	List<?> getBranchWiseStudents(List<Long> branches, String from, String to);
	List<?> getBadDebts(List<Long> branches, String from, String to);
//	List<?> getAmountPaid(long registrationNo , long batchId);
}
