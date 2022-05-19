package dao;

import java.util.List;

import models.Employee;

public interface EmployeeDAO {

	public Employee getEmployee(int employeeNumber);
	public List<Employee> getAllEmployee();
	public boolean editarEmployee(Employee employee, int employeeNumber);
	public boolean borrarEmployee(int employeeNumber);
	public boolean insertEmployee(Employee employee);
	public List<Employee> getAllEmployeesBy(String tabla, String officeCode);
}
