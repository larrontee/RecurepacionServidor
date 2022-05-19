package dao;

import java.util.List;

import models.User;

public interface UsersDAO {

	public boolean existeUser(String usuario);
	public boolean buenosDatosUser(String usuario,String pass);
	boolean buenosDatosUserEmail(String usuario, String pass);
	public User getUser(String usuario);
	public User getUserEmail(String email);
	public List<User> getAllUsers();
	public boolean registrarUsuario(User usuario);
	public boolean updateUsuario(User user, String usuario, boolean updatePass);
	public boolean deleteUsuario(String usuario);
}
