package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.PoolDB;
import dao.PaymentDAO;
import models.Payment;



public class PaymentDAOImp implements PaymentDAO {
	@Override
	public List<Payment> getAllPayments(){
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		
		try {
			String sql = "SELECT * FROM payments";
			PreparedStatement  stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Payment payment = new Payment();
				payment.setCustomerNumber(result.getInt("customerNumber"));
				payment.setCheckNumber(result.getString("checkNumber"));
				payment.setDate(result.getString("paymentDate"));
				payment.setAmount(result.getDouble("amount"));
				paymentList.add(payment);
			}
			return paymentList;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Payment getPayment(int customerNumber, String checkNumber) {
		
		try {
			String sql = "SELECT * FROM payments WHERE customerNumber=? AND checkNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, customerNumber);
			stmt.setString(2, checkNumber);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Payment p = new Payment();
				p.setCustomerNumber(result.getInt("customerNumber"));
				p.setCheckNumber(result.getString("checkNumber"));
				p.setDate(result.getString("paymentDate"));
				p.setAmount(result.getDouble("amount"));
				
				return p;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}

	@Override
	public boolean removePayment(int customerNumber, String checkNumber) {
		try {
			String sql = "DELETE  FROM payments WHERE customerNumber=? AND checkNumber=?";
			PreparedStatement  stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, customerNumber);
			stmt.setString(2, checkNumber);
			
			return stmt.executeUpdate()==0? false:true;
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updatePayment(Payment payment, int old_custNumber,String old_ckeckNumber) {
		try {
			String sql= "UPDATE payments SET customerNumber=? ,checkNumber=?, paymentDate=?, amount=? WHERE customerNumber=? AND checkNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, payment.getCustomerNumber());
			stmt.setString(2, payment.getCheckNumber());
			stmt.setString(3, payment.getDate().replace("/", "-"));
			stmt.setDouble(4, payment.getAmount());
			stmt.setInt(5, old_custNumber);
			stmt.setString(6, old_ckeckNumber);
			
			return stmt.executeUpdate()!=0? true: false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	@Override
	public boolean insertPayment(Payment payment) {
		try {
			String sql = "INSERT INTO payments (customerNumber,checkNumber,paymentDate,amount) VALUES(?, ?, ?, ?)";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, payment.getCustomerNumber());
			stmt.setString(2, payment.getCheckNumber());
			stmt.setString(3, payment.getDate().replace("/", "-"));
			stmt.setDouble(4, payment.getAmount());
			return stmt.executeUpdate()==0?false:true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
