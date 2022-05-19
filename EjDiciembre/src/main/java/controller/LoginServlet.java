package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.imp.UsersDAOImp;
import models.User;

/**
 * Servlet implementation class inicio
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginServlet.class);

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usuario = request.getParameter("user");
		String pass = request.getParameter("password");
		if (usuario != null && pass != null) {

			if (new UsersDAOImp().buenosDatosUser(usuario, pass)) {
				User u = new UsersDAOImp().getUser(usuario);
				HttpSession sesion = request.getSession();
				String nombreCompleto = u.getFirstName() + " " + u.getLastName();
				sesion.setAttribute("usuario", u.getUsuario());
				sesion.setAttribute("nombre", nombreCompleto);
				sesion.setAttribute("rol", u.getRol());

				if (u.getRol().equals("usuario")) {
					logger.info("Usuario " + u.getUsuario() + " logueado [InicioServlet.class]");
					response.sendRedirect("Inicio");
				} else if (u.getRol().equals("admin")) {
					logger.info("Admin " + u.getUsuario() + " logueado [InicioServlet.class]");
					response.sendRedirect("Inicio");
				}
			}
		} else {
			logger.info("Usuario " + usuario + " intento de loggin fallido [InicioServlet.class]");
			response.sendRedirect("LoginServLet");
		}
	}
}
