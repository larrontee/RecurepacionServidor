package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.PoolDB;
import dao.ProductsDAO;
import models.Product;

public class ProductsDAOImp implements ProductsDAO{

	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> productos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM products";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Product producto = new Product(
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getString(6),
						result.getInt(7),
						result.getDouble(8),
						result.getDouble(9)
						);
						productos.add(producto);
			}
			return productos;
		}catch (SQLException e) {
			System.out.println( e.getMessage());
		}
		return null;
	}

	@Override
	public boolean modificarProducto(Product producto, String productCode) {
		try {
			String sql = "UPDATE products SET productCode=?, productName=?, productLine=?, "
					+ "productScale=?, productVendor=?, productDescription=?, "
					+ "quantityInStock=?, buyPrice=?, MSRP=? WHERE productCode=?";
			
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			
			stmt.setString(1, producto.getProductCode());
			stmt.setString(2, producto.getProductName());
			stmt.setString(3, producto.getProductLine());
			stmt.setString(4, producto.getProductScale());
			stmt.setString(5, producto.getProductVendor());
			stmt.setString(6, producto.getProductDescription());
			stmt.setInt(7, producto.getQuantityInStock());
			stmt.setDouble(8, producto.getBuyPrice());
			stmt.setDouble(9,producto.getMSRP());
			stmt.setString(10, productCode);
			return stmt.executeUpdate()==0?false:true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Product getProduct(String codigoProducto) {
		try {
			String sql = "SELECT * FROM products WHERE productCode=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, codigoProducto);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Product producto = new Product(
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getString(6),
						result.getInt(7),
						result.getDouble(8),
						result.getDouble(9)
						);
				return producto;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteProducto(String codigoProducto) {
		try {
			String sql = "DELETE FROM products WHERE productCode=?";
			
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, codigoProducto);
			boolean decision = stmt.executeUpdate()!=0?true:false;
			System.out.println("Delete producto: "+decision);
			return decision;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean insertProducto(Product producto) {
		try {
			String sql = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			
			stmt.setString(1, producto.getProductCode());
			stmt.setString(2, producto.getProductName());
			stmt.setString(3, producto.getProductLine());
			stmt.setString(4, producto.getProductScale());
			stmt.setString(5, producto.getProductVendor());
			stmt.setString(6, producto.getProductDescription());
			stmt.setInt(7, producto.getQuantityInStock());
			stmt.setDouble(8, producto.getBuyPrice());
			stmt.setDouble(9,producto.getMSRP());
			return stmt.executeUpdate()==0?false:true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Product> getProductx(String productLine) {
		ArrayList<Product> productos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM products WHERE productLine=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, productLine);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Product producto = new Product(
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getString(6),
						result.getInt(7),
						result.getDouble(8),
						result.getDouble(9)
						);
						productos.add(producto);
			}
			return productos;
		}catch (SQLException e) {
			System.out.println( e.getMessage());
		}
		return null;
	}
	
}
