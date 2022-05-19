package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.imp.EmployeeDAOImp;
import dao.imp.OfficeDAOImp;
import dao.imp.ProductLineDAOImp;
import dao.imp.ProductsDAOImp;
import models.Employee;
import models.Office;
import models.Product;
import models.ProductLine;

/**
 * Servlet implementation class AddEmpleadoServlet
 */

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<ProductLine> categorias = new ProductLineDAOImp().getAllProductsLines();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pCode = request.getParameter("pCode");
		String pName = request.getParameter("pName");
		String pLine = request.getParameter("pLine");
		String pScale = request.getParameter("pScale");
		String pVendor = request.getParameter("pVendor");
		String pDescription = request.getParameter("pDescription");
		String pStock = request.getParameter("pStock");
		String price = request.getParameter("price");
		String msrp = request.getParameter("msrp");

		Integer Stock= Integer.parseInt(pStock);
		Double Price= Double.parseDouble(price);
		Double MSRP= Double.parseDouble(msrp);



		Product p = new Product();

		p.setBuyPrice(Price);
		p.setMSRP(MSRP);
		p.setProductCode(pCode);
		p.setProductDescription(pDescription);
		p.setProductLine(pLine);
		p.setProductName(pName);
		p.setProductScale(pScale);
		p.setProductVendor(pVendor);
		p.setQuantityInStock(Stock);
		
		
		
		if(new ProductsDAOImp().getProduct(pCode)!=null) {
			HttpSession sesion = request.getSession();

			sesion.setAttribute("pName", pName);
			sesion.setAttribute("pLine", pLine);
			sesion.setAttribute("pScale", pScale);
			sesion.setAttribute("pVendor", pVendor);
			sesion.setAttribute("pDescription", pDescription);
			sesion.setAttribute("pStock", pStock);
			sesion.setAttribute("price", price);
			sesion.setAttribute("msrp", msrp);
			
			request.setAttribute("error", "ya existe un producto con este codigo");
			
			response.sendRedirect("AddProduct");
			
		}else {
			new ProductsDAOImp().insertProducto(p);	
		}
		
		
		
		}

}
