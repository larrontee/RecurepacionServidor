package dao;

import java.util.List;

import models.Product;

public interface ProductsDAO {
	public List<Product> getAllProducts();
	public Product getProduct(String codigoProducto);
	public boolean modificarProducto(Product producto, String productCode); 
	public boolean deleteProducto(String codigoProducto);
	public boolean insertProducto(Product producto);
	public List<Product> getProductx(String productLine);
}
