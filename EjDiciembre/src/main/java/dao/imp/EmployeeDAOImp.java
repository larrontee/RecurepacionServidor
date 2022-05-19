package dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import conexion.PoolDB;
import dao.EmployeeDAO;
import models.Employee;

public class EmployeeDAOImp implements EmployeeDAO{
	public static void main(String[] args) {
		EmployeeDAOImp edi = new EmployeeDAOImp();
		System.out.println(edi.getAllEmployeesBy("officeCode", "1"));
	}

	@Override
	public Employee getEmployee(int employeeNumber) {
		try {
			String sql="SELECT * FROM employees WHERE employeeNumber =?";

			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, employeeNumber);
			ResultSet result = stmt.executeQuery();
			result.next();
			return new Employee(
					result.getInt("employeeNumber"),
					result.getString("lastName"),
					result.getString("firstName"),
					result.getString("extension"),
					result.getString("email"),
					result.getString("officeCode"),
					result.getInt("reportsTo"),
					result.getString("jobTitle")
					);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
//			String sql="SELECT * FROM employees";
			String sql="SELECT e.employeeNumber as employeeNumber, e.lastName as lastName, e.firstName as firstName, o.city as city , e.jobTitle as jobTitle ,e2.firstName \n"
					+ "as jefe FROM employees e inner join offices o on e.officeCode =o.officeCode LEFT join employees e2 on e.reportsTo =e2.employeeNumber";
			
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			
			List<Employee> empleados = new ArrayList<>();
			while(result.next()) {
				Employee empleado = new Employee(
					result.getInt("employeeNumber"),
					result.getString("lastName"),
					result.getString("firstName"),
//					result.getString("extension"),
//					result.getString("email"),
//					result.getString("officeCode"),
//					result.getInt("reportsTo"),
					result.getString("jobTitle"),
					result.getString("city"),
					result.getString("jefe")
					);
				
				
				
				empleados.add(empleado);
			}
			return empleados;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean editarEmployee(Employee employee, int employeeNumber) {
		try {
			String sql="UPDATE employees SET employeeNumber=?, lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, employee.getEmployeeNumber());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getFirstName());
			stmt.setString(4, employee.getExtension());
			stmt.setString(5, employee.getEmail());
			stmt.setString(6, employee.getOfficeCode());
			stmt.setInt(7, employee.getReportsTo());
			stmt.setString(8, employee.getJobTitle());
			return  stmt.executeUpdate()!=0? true : false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean borrarEmployee(int employeeNumber) {
		try {
			String sql="DELETE FROM employees WHERE employeeNumber=?";
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1,employeeNumber);
			
			return  stmt.executeUpdate()!=0? true : false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployeesBy(String columna, String value) {
		ArrayList<String> tablas = new ArrayList<>(Arrays.asList("employeeNumber", "lastName", "firstName", "extension", "email", "officeCode", "reportsTo", "jobTitle"));
		if(tablas.indexOf(columna)!=-1) {
			try {
				ArrayList<Employee> empleados = new ArrayList<>();
				String sql = "SELECT * FROM employees WHERE "+columna+"=?";
				PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
				if(tablas.indexOf(columna)==0 || tablas.indexOf(columna) == 6) {
					System.out.println("numerico");
					stmt.setInt(1, Integer.parseInt(value));
				}else {
					System.out.println("string");
					stmt.setString(1, value);
				}
				ResultSet result = stmt.executeQuery();
				int contador=1;
				while(result.next()) {
					Employee empleado = new Employee(
						result.getInt("employeeNumber"),
						result.getString("lastName"),
						result.getString("firstName"),
						result.getString("extension"),
						result.getString("email"),
						result.getString("officeCode"),
						result.getInt("reportsTo"),
						result.getString("jobTitle")
						);
					System.out.println(contador);
					contador++;
					empleados.add(empleado);
				}
				return empleados;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			return null;
		}
		return null;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		try {
			String sql;
			if(employee.getReportsTo()!=0) {
				 sql = "INSERT INTO employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES(?,?,?,?,?,?,?,?)";
			}else {
				 sql = "INSERT INTO employees(employeeNumber, lastName, firstName, extension, email, officeCode, jobTitle) VALUES(?,?,?,?,?,?,?)";
			}
			
			PreparedStatement stmt = new PoolDB().getConnection().prepareStatement(sql);
			stmt.setInt(1, employee.getEmployeeNumber());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getFirstName());
			stmt.setString(4, employee.getExtension());
			stmt.setString(5, employee.getEmail());
			stmt.setString(6, employee.getOfficeCode());
			if(employee.getReportsTo()!=0) {
				System.out.println("Con pass");
				stmt.setInt(7, employee.getReportsTo());
				stmt.setString(8, employee.getJobTitle());
			}else {
				stmt.setString(7, employee.getJobTitle());
			}
			
			return stmt.executeUpdate() != 0? true : false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	

}
