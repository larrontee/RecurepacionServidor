package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.CustomerDAOImp;
import dao.imp.OrderDAOImp;
import models.Customer;
import models.Order;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssigmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderCode=request.getParameter("id");
		Integer idProducto= Integer.parseInt(orderCode);
		
		request.setAttribute("orderCode",orderCode);
		Order order=new OrderDAOImp().getOrder(idProducto);
		
		request.setAttribute("order",order);
		List<Customer> customers=new CustomerDAOImp().getAllCustomers();
		request.setAttribute("customers",customers);
		request.getRequestDispatcher("/WEB-INF/view/changeOrderCustomer.jsp").forward(request, response);		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
