package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.PoolDB;
import dao.OrderDetailDAO;
import models.OrderDetail;

public class OrderdetailDAOImp implements OrderDetailDAO {

	@Override
	public List<OrderDetail> getOrderDetail(int orderNumber) {
		try {
			String sql = "SELECT * FROM orderdetails WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			List<OrderDetail> detalles = new ArrayList<>();
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				detalles.add(new OrderDetail(result.getInt("orderNumber"), result.getString("productCode"),
						result.getInt("quantityOrdered"), result.getDouble("priceEach"),
						result.getInt("orderLineNumber")));
			}
			return detalles;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderDetail getOrderDetail(int orderNumber, String productCode) {
		try {
			String sql = "SELECT * FROM orderdetails WHERE orderNumber=? AND productCode=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			stmt.setString(2, productCode);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				return new OrderDetail(result.getInt("orderNumber"), result.getString("productCode"),
						result.getInt("quantityOrdered"), result.getDouble("priceEach"),
						result.getInt("orderLineNumber"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean updatePKOrderDetails(int oldOrderNumber, int orderNumber) {
		try {
			String sql = "UPDATE orderdetails SET orderNumber=? WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			stmt.setInt(2, oldOrderNumber);
			System.out.println("updatePKOrderDetails...");
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteOrderDetails(int orderNumber, String productCode) {
		try {
			String sql = "DELETE FROM orderdetails WHERE orderNumber=? AND productCode=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			stmt.setString(2, productCode);
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteOrderDetails(int orderNumber) {
		try {
			String sql = "DELETE FROM orderdetails WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean deleteOrderDetails(String productCode) {
		try {
			String sql = "DELETE FROM orderdetails WHERE productCode=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, productCode);
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean insertOrderDetails(OrderDetail orderdetail) {
		try {
			String sql = "INSERT INTO orderdetails VALUES(?,?,?,?,?)";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderdetail.getOrderNumber());
			stmt.setString(2, orderdetail.getProductCode());
			stmt.setInt(3, orderdetail.getQuantityOrdered());
			stmt.setDouble(4, orderdetail.getPriceEach());
			stmt.setInt(5, orderdetail.getOrderLineNumber());
			return stmt.executeUpdate() !=0 ?true:false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
