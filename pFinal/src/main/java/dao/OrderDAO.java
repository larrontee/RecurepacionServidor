package dao;

import java.util.List;

import models.Order;
import models.OrderDetail;

public interface OrderDAO {
	
	public Order getOrder(int orderNumber);
	public List<Order> getAllOrder();
	public boolean deleteOrder(int orderNumber);
	public boolean updateOrder(Order order,  int orderNumber);
	public boolean updateOrderCustomer(int  orderId,  int customerNumber);
	public boolean insertOrder(Order order, List<OrderDetail> orderdetails);
}
