package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.PoolDB;
import dao.ProductLineDAO;
import models.ProductLine;

public class ProductLineDAOImp implements ProductLineDAO{
	public static void main(String[] args) {
		System.out.println(new ProductLineDAOImp().updateProductLine(new ProductLine("Classic Cars", "Attention car enthusiasts: Make your wildest car ownership dreams come true. Whether you are looking for classic muscle cars, dream sports cars or movie-inspired miniatures, you will find great choices in this category. These replicas feature superb attention to detail and craftsmanship and offer features such as working steering system, opening forward compartment, opening rear trunk with removable spare wheel, 4-wheel independent spring suspension, and so on. The models range in size from 1:10 to 1:24 scale and include numerous limited edition and several out-of-production vehicles. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.", "<br>",null), "Classic Cars"));
	}
	@Override
	public ProductLine getProductLine(String productLine) {
		try {
			String sql = "SELECT * FROM productlines WHERE productLine=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, productLine);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				return new ProductLine(
						result.getString("productLine"),
						result.getString("textDescription"),
						result.getString("htmlDescription"),
						result.getString("image")
						);
			}

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<ProductLine> getAllProductsLines() {
		try {
			String sql = "SELECT * FROM productlines";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<ProductLine> lineas = new ArrayList<>();
			while(result.next()) {
				lineas.add(
						new ProductLine(
								result.getString("productLine"),
								result.getString("textDescription"),
								result.getString("htmlDescription"),
								result.getString("image")
						)
				);
			}
			return lineas;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteProductLine(String productLine) {
		try {
			String sql = "DELETE FROM productlines WHERE productLine=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, productLine);
			return stmt.executeUpdate()!=0?true:false;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateProductLine(ProductLine productLineObject, String productLine) {
		try {
			String sql = "UPDATE productlines SET productLine=?, textDescription=?, htmlDescription=?, image=? WHERE productLine=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, productLineObject.getProductLine());
			stmt.setString(2, productLineObject.getTextDescription());
			stmt.setString(3, productLineObject.getHtmlDescription());
			stmt.setString(4, productLineObject.getImage());
			stmt.setString(5, productLine);
			return stmt.executeUpdate()!=0?true:false;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean createProductLine(ProductLine productLine) {
		try {
			String sql = "INSERT INTO productlines (?,?,?,?)";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, productLine.getProductLine());
			stmt.setString(2, productLine.getTextDescription());
			stmt.setString(3, productLine.getHtmlDescription());
			stmt.setString(4, productLine.getImage());
			return stmt.executeUpdate()!=0?true:false;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		return false;
	}

}
