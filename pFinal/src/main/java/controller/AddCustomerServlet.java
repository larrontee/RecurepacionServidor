package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.CustomerDAOImp;
import dao.imp.EmployeeDAOImp;
import models.Customer;
import models.Employee;

/**
 * Servlet implementation class AddCustomer
 */

public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		List<Employee> empleados=new EmployeeDAOImp().getAllEmployee();
		
		request.setAttribute("employees", empleados);
    	request.getRequestDispatcher("/WEB-INF/view/addCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerNumber = request.getParameter("customerNumber");
		String customerName = request.getParameter("customerName");
		String contactLastName = request.getParameter("contactLastName");
		String contactFirstName = request.getParameter("contactFirstName");
		String phone = request.getParameter("phone");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String salesRepEmployeeNumber = request.getParameter("salesRepEmployeeNumber");
		String creditLimit = request.getParameter("creditLimit");
		
		Customer c= new Customer();
		c.setCustomerNumber(Integer.parseInt(customerNumber));
		c.setCustomerName(customerName);
		c.setContactLastName(contactLastName);
		c.setContactFirstName(contactFirstName);
		c.setPhone(phone);
		c.setAddressLine1(addressLine1);
		c.setAddressLine2(addressLine2);
		c.setCity(city);
		c.setState(state);
		c.setPostalCode(postalCode);
		c.setCountry(country);
		c.setSalesRepEmployeeNumber(Integer.parseInt(salesRepEmployeeNumber));
		c.setCreditLimitv(Double.parseDouble(creditLimit));
			
		
		
		if(new CustomerDAOImp().getCustomer(Integer.parseInt(customerNumber))!=null) {
			response.sendRedirect("AddCustomers");
		}else {
	        new CustomerDAOImp().insertCustomer(c);
	        response.sendRedirect("Inicio");
		}
		
        
	}

}
