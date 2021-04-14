package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.IUserImplDAO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/ServletLogin", "/login" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		if (request.getServletPath().equals("/login")) {
			IUserImplDAO u = new IUserImplDAO();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = u.getUser(username, password);
			if (user != null) {
				if (user.getRole().equals("admin")) {
					request.getRequestDispatcher("/HomeAdmin.jsp").forward(request, response);
				}
				if (user.getRole().equals("etudiant")) {
					request.getRequestDispatcher("/HomeEtudiant.jsp").forward(request, response);
				}
				if (user.getRole().equals("professeur")) {
					request.getRequestDispatcher("/HomeProfesseur.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/page_404.jsp").forward(request, response);
			}
		}
	}
}
