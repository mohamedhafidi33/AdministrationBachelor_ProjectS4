package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Gender;
import beans.Professeur;
import dao.IMatiereDAO;
import dao.IMatiereImplDAO;
import dao.IProfesseurDAO;
import dao.IProfesseurImplDAO;

/**
 * Servlet implementation class ServletGestionProf
 */
@WebServlet(urlPatterns = { "/ajouterProf","/addProf" })
public class ServletGestionProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Professeur prof=new Professeur();
	IProfesseurDAO iprof=new IProfesseurImplDAO();
	IMatiereDAO imatiere=new IMatiereImplDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.print(request.getServletPath());
		
		if(request.getServletPath().equals("/ajouterProf")) {
			request.setAttribute("listMatiere",imatiere.listeMatiere());
			request.getRequestDispatcher("ajouterProf.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/addProf")) {
			prof.setNom(request.getParameter("nom"));
			prof.setPrenom(request.getParameter("prenom"));
			prof.setCin(request.getParameter("cin"));
			prof.setEmail(request.getParameter("email"));
			prof.setNationalite(request.getParameter("nationalite"));
			prof.setVille(request.getParameter("ville"));
			prof.setProvince(request.getParameter("province"));
			System.out.println(request.getParameter("gender"));
			prof.setSexe(Gender.valueOf(request.getParameter("gender")));
			iprof.ajouterProf(prof);
			request.getRequestDispatcher("ajouterProf.jsp").forward(request, response);
		}
		
	}

}
