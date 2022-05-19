package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.EmployeeDAOImp;
import dao.imp.OfficeDAOImp;
import models.Employee;
import models.Office;

/**
 * Servlet implementation class AddEmpleadoServlet
 */

public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> empleados= new EmployeeDAOImp().getAllEmployee();
		List<Office> oficinas= new OfficeDAOImp().getAllOffice();
		

		request.setAttribute("jefes", empleados);
		request.setAttribute("oficinas", oficinas);
		
		request.getRequestDispatcher("/WEB-INF/view/addEmpleado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jefe = request.getParameter("jefe");
		String office = request.getParameter("office");
		String number = request.getParameter("number");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String extension = request.getParameter("extension");
		String jobTitle = request.getParameter("jobTitle");
		
		
		Integer numeroInt=Integer.parseInt(number);
		Integer jefeInt=Integer.parseInt(jefe);


		Employee employee= new Employee();

		
		
		employee.setEmployeeNumber(numeroInt);
		employee.setExtension(extension);
		employee.setFirstName(firstName);
		employee.setJobTitle(jobTitle);
		employee.setLastName(lastName);
		employee.setOfficeCode(office);
		employee.setReportsTo(jefeInt);
		
		new EmployeeDAOImp().insertEmployee(employee);
		
		}

}
