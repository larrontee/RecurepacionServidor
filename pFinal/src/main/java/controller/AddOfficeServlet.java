package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.CustomerDAOImp;
import dao.imp.OfficeDAOImp;

/**
 * Servlet implementation class AddOfficeServlet
 */
public class AddOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOfficeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/addOffice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String officeCode= request.getParameter("officeCode");
			String city= request.getParameter("city");
			String phone= request.getParameter("phone");
			String addressLine1= request.getParameter("addressLine1");
			String addressLine2= request.getParameter("addressLine2");
			String state= request.getParameter("state");
			String country= request.getParameter("country");
			String postalCode= request.getParameter("postalCode");
			String territory= request.getParameter("territory");
			
			if(new OfficeDAOImp().getOffice(officeCode)!=null) {
				response.sendRedirect("AddOffices");
			}else {
		        response.sendRedirect("Inicio");				
			}

			
		
		
	}

}
