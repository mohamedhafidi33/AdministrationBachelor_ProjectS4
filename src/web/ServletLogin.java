package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.IEtudiantDAO;
import dao.IEtudiantImplDAO;
import dao.IProfesseurDAO;
import dao.IProfesseurImplDAO;
import dao.IUserDAO;
import dao.JTest;
import dao.UserTest;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/ServletLogin", "/login" })
public class ServletLogin extends HttpServlet {
	UserTest u = new UserTest();
	IProfesseurDAO iprof = new IProfesseurImplDAO();
	IEtudiantDAO ietud = new IEtudiantImplDAO();
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
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		System.out.print(request.getServletPath());
		if (request.getServletPath().equals("/login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			/*---------------------------------------Checking if username and password matched---------------------------------*/

			if (u.login(username, password)) {

				User user = u.getUser(username, password);
				System.out.println("username" + user.getUsername());
				System.out.println("role: " + user.getRole());
				System.out.println("role: " + user.getId());

				/*---------------------------------------Admin, Professeur or Etudiant ????---------------------------------*/

				if (user.getRole().name().equals("admin")) {
					System.out.println("votre nom : " + iprof.getProf(user).getNom());
					session.setAttribute(password, user);
					System.out.print("you are an admin Maaaan!!!");
					request.getRequestDispatcher("/HomeAdmin.jsp").forward(request, response);

				} else if (user.getRole().name().equals("etudiant")) {
					session.setAttribute("etudiant", ietud.getEtudiant(user));
					request.getRequestDispatcher("/HomeEtudiant.jsp").forward(request, response);

				} else if (user.getRole().name().equals("professeur")) {
					session.setAttribute("professeur", iprof.getProf(user));
					request.getRequestDispatcher("/HomeProfesseur.jsp").forward(request, response);
				}

				/*---------------------------------------username and password don't match ==> Error---------------------------------*/

			} else {
				System.out.print("failed!!!");
				request.getRequestDispatcher("/page_404.jsp").forward(request, response);
			}
		} // else System.out.print("zefzef");
	}
}
