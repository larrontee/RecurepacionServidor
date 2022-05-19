package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.PoolDB;
import dao.OrderDAO;
import models.Order;

import models.OrderDetail;

public class OrderDAOImp implements OrderDAO {

	@Override
	public Order getOrder(int orderNumber) {
		try {
			String sql = "SELECT * FROM orders WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				System.out.println("cogiendo orden " + orderNumber);
				return new Order(result.getInt("orderNumber"), result.getString("orderDate"),
						result.getString("requiredDate"), result.getString("shippedDate"), result.getString("status"),
						result.getString("comments"), result.getInt("customerNumber"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		try {
			String sql = "SELECT * FROM orders";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<Order> ordenes = new ArrayList<>();
			while (result.next()) {
				Order orden = new Order(result.getInt("orderNumber"), result.getString("orderDate"),
						result.getString("requiredDate"), result.getString("shippedDate"), result.getString("status"),
						result.getString("comments"), result.getInt("customerNumber"));
				ordenes.add(orden);
			}
			return ordenes;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteOrder(int orderNumber) {

		try {
			String sql = "DELETE FROM orders  WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, orderNumber);
			System.out.println("deleteOrder...");
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateOrder(Order order, int orderNumber) {
		try {
			System.out.println("UpdateOrder ....");
			String sql = "UPDATE orders SET orderNumber=?, orderDate=?, requiredDate=?, shippedDate=?, status=?, comments=?, customerNumber=? WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);

			stmt.setInt(1, order.getOrderNumber());
			stmt.setString(2, order.getOrderDate());
			stmt.setString(3, order.getRequiredDate());
			stmt.setString(4, order.getShippedDate());
			stmt.setString(5, order.getStatus());
			stmt.setString(6, order.getComments());
			stmt.setInt(7, order.getCustomerNumber());
			stmt.setInt(8, orderNumber);
			return stmt.executeUpdate() != 0?true:false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	@Override
	public boolean insertOrder(Order order, List<OrderDetail> orderdetails) {
		try {
			String sql = "INSERT INTO orders VALUE(?,?,?,?,?,?,?)";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, order.getOrderNumber());
			stmt.setString(2, order.getOrderDate());
			stmt.setString(3, order.getRequiredDate());
			stmt.setString(4, order.getShippedDate());
			stmt.setString(5, order.getStatus());
			stmt.setString(6, order.getComments());
			stmt.setInt(7, order.getCustomerNumber());
			if (stmt.executeUpdate() != 0) {
				if (orderdetails != null) {
					OrderdetailDAOImp oddi = new OrderdetailDAOImp();
					for (OrderDetail orderdertail : orderdetails) {
						oddi.insertOrderDetails(orderdertail);
					}
				}

				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateOrderCustomer(int orderId, int customerNumber) {
		try {
			System.out.println("UpdateOrder ....");
			String sql = "UPDATE orders SET  customerNumber=? WHERE orderNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);

//			stmt.setInt(1, order.getOrderNumber());
//			stmt.setString(2, order.getOrderDate());
//			stmt.setString(3, order.getRequiredDate());
//			stmt.setString(4, order.getShippedDate());
//			stmt.setString(5, order.getStatus());
//			stmt.setString(6, order.getComments());
//			stmt.setInt(7, order.getCustomerNumber());
//			stmt.setInt(8, orderNumber);
			return stmt.executeUpdate() != 0?true:false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	

}
