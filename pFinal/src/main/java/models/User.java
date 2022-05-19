package models;
import java.io.Serializable;

public class User implements Serializable{
	private String usuario;
	private String password;
	private String email;
	private String rol;
	private String firstName;
	private String lastName;
	
	public User() {}

	public User(String usuario, String email,String password, String rol, String firstName, String lastName) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
