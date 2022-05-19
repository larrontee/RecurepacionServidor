package dao.imp;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import conexion.PoolDB;
import dao.UsersDAO;
import models.User;
import utils.PasswordHashGenerator;

public class UsersDAOImp implements UsersDAO {
	final static Logger logger = Logger.getLogger(UsersDAOImp.class);

	@Override
	public boolean existeUser(String usuario) {
		try {
			String sql = "SELECT * FROM users WHERE usuario=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public User getUser(String usuario) {
		try {
			String sql = "SELECT * FROM users WHERE usuario=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			User user= new User();
			while (rs.next()) {
                user = new User();
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRol(rs.getString("role"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("LastName"));
            }
			return user;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	@Override
	public User getUserEmail(String email) {
		try {
			String sql = "SELECT * FROM users WHERE email=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				return new User(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean registrarUsuario(User usuario) {
		try {
			usuario.setPassword(PasswordHashGenerator.hashPassword(usuario.getPassword()));
			String sql = "INSERT INTO users VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getPassword());
			stmt.setString(4, usuario.getRol());
			stmt.setString(5, usuario.getFirstName());
			stmt.setString(6, usuario.getLastName());
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean buenosDatosUser(String usuario, String pass) {

		try {
			String sql = "SELECT * FROM users WHERE usuario=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, usuario);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String user = result.getString("usuario");
				String password = result.getString("password");
				try {
					return PasswordHashGenerator.checkPassword(pass, password);
				} catch (IllegalArgumentException e) {
					logger.error(e.getMessage() + "[UserDaoImpl.class]");
				}
			}
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
	
	
	@Override
	public boolean buenosDatosUserEmail(String email, String pass) {

		try {
			String sql = "SELECT * FROM users WHERE email=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String user = result.getString("usuario");
				String password = result.getString("password");
				try {
					return PasswordHashGenerator.checkPassword(pass, password);
				} catch (IllegalArgumentException e) {
					logger.error(e.getMessage() + "[UserDaoImpl.class]");
				}
			}
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	@Override
	public List<User> getAllUsers() {
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<User> usuarios = new ArrayList<>();
			while (result.next()) {
				usuarios.add(new User(result.getString("usuario"), "", result.getString("email"),
						result.getString("rol"), result.getString("firstName"), result.getString("lastName")));
			}
			return usuarios;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean updateUsuario(User user, String usuario, boolean updatePass) {
		try {
			String sql;
			if (updatePass) {
				sql= "UPDATE  users SET usuario =?, email=?, rol=?, firstName=?, lastName=?, password =? WHERE usuario=?";
			} else {
				sql = "UPDATE  users SET usuario =?, email=?, rol=?, firstName=?, lastName=? WHERE usuario=?";
			}
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, user.getUsuario());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getRol());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			if (updatePass) {
				stmt.setString(6, user.getPassword());
				stmt.setString(7, usuario);
			} else {
				stmt.setString(6, usuario);
			}

			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteUsuario(String usuario) {
		try {
			String sql = "DELETE FROM users WHERE usuario=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setString(1, usuario);
			return stmt.executeUpdate() != 0 ? true : false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
