package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.PoolDB;
import dao.CustomerDAO;
import models.Customer;

public class CustomerDAOImp implements CustomerDAO {
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM customers";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int customerNumber = result.getInt("customerNumber");
				String customerName = result.getString("customerName");
				String contactLastName = result.getString("contactLastName");
				String contactFirstName = result.getString("contactFirstName");
				String phone = result.getString("phone");
				String addressLine1 = result.getString("addressLine1");
				String addressLine2 = result.getString("addressLine2");
				String city = result.getString("city");
				String state = result.getString("state");
				String postalCode = result.getString("postalCode");
				String country = result.getString("country");
				int salesRepEmployeeNumber = result.getInt("salesRepEmployeeNumber");
				double creditLimit = result.getDouble("creditLimit");
				lista.add(new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone,
						addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber,
						creditLimit));
			}
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Customer getCustomer(int customerNumber) {
		try {
			String sql = "SELECT * FROM customers WHERE customerNumber =?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, customerNumber);
			ResultSet result = stmt.executeQuery();
			result.next();
			String customerName = result.getString("customerName");
			String contactLastName = result.getString("contactLastName");
			String contactFirstName = result.getString("contactFirstName");
			String phone = result.getString("phone");
			String addressLine1 = result.getString("addressLine1");
			String addressLine2 = result.getString("addressLine2");
			String city = result.getString("city");
			String state = result.getString("state");
			String postalCode = result.getString("postalCode");
			String country = result.getString("country");
			int salesRepEmployeeNumber = result.getInt("salesRepEmployeeNumber");
			double creditLimit = result.getDouble("creditLimit");
			return new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,
					addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int customerNumber) {
		try {
			String sql = "DELETE FROM customers WHERE customerNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, customerNumber);
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer, int oldCustomerNumber) {
		try {
			String sql = "UPDATE customers SET customerNumber=?, customerName=?, contactLastName=?, contactFirstName=?, "
					+ "phone=?, addressLine1=?, addressLine2=?, city=?, state=?, "
					+ "postalCode=?, country=?, salesRepEmployeeNumber=?,creditLimit=? WHERE customerNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, customer.getCustomerNumber());
			stmt.setString(2, customer.getCustomerName());
			stmt.setString(3, customer.getContactLastName());
			stmt.setString(4, customer.getContactFirstName());
			stmt.setString(5, customer.getPhone());
			stmt.setString(6, customer.getAddressLine1());
			stmt.setString(7, customer.getAddressLine2());
			stmt.setString(8, customer.getCity());
			stmt.setString(9, customer.getState());
			stmt.setString(10, customer.getPostalCode());
			stmt.setString(11, customer.getCountry());
			stmt.setInt(12, customer.getSalesRepEmployeeNumber());
			stmt.setDouble(13, customer.getCreditLimit());
			stmt.setInt(14, oldCustomerNumber);
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getAllCustomersNames() {
		List<String> lista = new ArrayList<>();
		try {
			String sql = "SELECT c.customerName,c.customerNumber from customers c inner join orders o on c.customerNumber =o.customerNumber GROUP by c.customerName;";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int customerNumber= result.getInt("customerNumber");
				String cNumber= Integer.toString(customerNumber);
				String customerName = result.getString("customerName");
				lista.add(customerNumber, customerName);
			}
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
