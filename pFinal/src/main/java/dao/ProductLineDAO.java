package dao;

import java.util.List;

import models.ProductLine;

public interface ProductLineDAO {

	public ProductLine getProductLine(String productLine);
	public List<ProductLine> getAllProductsLines();
	public boolean deleteProductLine(String productLine);
	public boolean updateProductLine(ProductLine productLineObject, String productLine);
	public boolean createProductLine(ProductLine productLine);
}
