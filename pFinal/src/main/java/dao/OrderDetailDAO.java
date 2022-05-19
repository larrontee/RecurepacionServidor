package dao;

import java.util.List;

import models.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> getOrderDetail(int orderNumber);
	public OrderDetail getOrderDetail(int orderNumber, String productCode);
	public boolean updatePKOrderDetails(int oldOrderNumber, int orderNumber);
	public boolean deleteOrderDetails(int orderNumber, String productCode);
	public boolean deleteOrderDetails(int orderNumber);
	public boolean deleteOrderDetails(String productCode);
	public boolean insertOrderDetails(OrderDetail orderdetail);
	
}
