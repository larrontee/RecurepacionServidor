package dao;

import java.util.List;

import models.Customer;

public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int customerNumber);
	public boolean deleteCustomer(int customerNumber);
	public boolean updateCustomer(Customer customer, int oldCustomerNumber);
	public boolean insertCustomer(Customer customer);
	public List<String> getAllCustomersNames();
}
