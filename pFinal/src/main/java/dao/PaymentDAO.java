package dao;

import java.util.List;

import models.Payment;

public interface PaymentDAO {
	public List<Payment> getAllPayments();
	public Payment getPayment(int customerNumber, String checkNumber);
	public boolean removePayment(int customerNumber, String checkNumber);
	public boolean updatePayment(Payment payment, int old_custNumber,String old_ckeckNumber);
	public boolean insertPayment(Payment payment);
}
