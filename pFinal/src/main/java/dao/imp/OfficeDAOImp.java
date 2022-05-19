package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.PoolDB;
import dao.OfficeDAO;
import models.Office;

public class OfficeDAOImp implements OfficeDAO{
		
		@Override
		public Office getOffice(String officeCode) {
			try {
				String sql="SELECT * FROM offices WHERE officeCode=?";
				
				PreparedStatement stmt= new PoolDB().getConnection().prepareStatement(sql);
				stmt.setString(1,officeCode);
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					return new Office(
							result.getString(1),
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6),
							result.getString(7),
							result.getString(8),
							result.getString(9)
							);
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}

		@Override
		public ArrayList<Office> getAllOffice() {
			ArrayList<Office> oficinas = new ArrayList<>();
			try {
				String sql = "SELECT * FROM offices";
				PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					Office off = new Office(
							result.getString(1),
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6),
							result.getString(7),
							result.getString(8),
							result.getString(9)
							);
					oficinas.add(off);
				}
				return oficinas;
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}

		@Override
		public boolean deleteOffice(String officeCode) {
			try {
				String sql = "DELETE FROM offices WHERE officeCode=?";
				PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
				stmt.setString(1, officeCode);
				return stmt.executeUpdate()!=0?true:false;
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return false;
		}

		@Override
		public boolean updateOffice(Office office, String officeCode) {
			try {
				String sql = "UPDATE offices SET officeCode=?, city=?, phone=?, addressLine1=?, addressLine2=?, "
								+ "state=?, country=?, postalCode=?, territory=? WHERE officeCode=?";
				PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
				stmt.setString(1, office.getOfficeCode());
				stmt.setString(2, office.getCity());
				stmt.setString(3, office.getPhone());
				stmt.setString(4, office.getAddressLine1());
				stmt.setString(5, office.getAddressLine2());
				stmt.setString(6, office.getState());
				stmt.setString(7, office.getCountry());
				stmt.setString(8, office.getPostalCode());
				stmt.setString(9, office.getTerritory());
				stmt.setString(10, officeCode);
				return stmt.executeUpdate() != 0? true : false;
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return false;
		}

		@Override
		public boolean insertOffice(Office office) {
			try {
				String sql = "INSERT INTO offices VALUE(?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
				stmt.setString(1, office.getOfficeCode());
				stmt.setString(2, office.getCity());
				stmt.setString(3, office.getPhone());
				stmt.setString(4, office.getAddressLine1());
				stmt.setString(5, office.getAddressLine2());
				stmt.setString(6, office.getState());
				stmt.setString(7, office.getCountry());
				stmt.setString(8, office.getPostalCode());
				stmt.setString(9, office.getTerritory());
				return stmt.executeUpdate() != 0? true : false;
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			return false;
		}

}
