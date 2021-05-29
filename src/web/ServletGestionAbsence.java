package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Etudiant;
import dao.IAbsenceDAO;
import dao.IAbsenceImplDAO;
import dao.IEtudiantDAO;
import dao.IEtudiantImplDAO;
import dao.IFiliereDAO;
import dao.IFiliereImplDAO;
import dao.IMatiereDAO;
import dao.IMatiereImplDAO;

/**
 * Servlet implementation class ServletGestionAbsence
 */
@WebServlet(urlPatterns = {"/AjouterAbsence","/absenceData","/addAbsence"})
public class ServletGestionAbsence extends HttpServlet {
	IMatiereDAO imat=new IMatiereImplDAO();
	IFiliereDAO ifil=new IFiliereImplDAO();
	IEtudiantDAO itud=new IEtudiantImplDAO();
	IAbsenceDAO iAbsn=new IAbsenceImplDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionAbsence() {
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
		if(request.getServletPath().equals("/AjouterAbsence")) {
			System.out.println(imat.ListMatiereByProf(Integer.parseInt(session.getAttribute("professeur_id").toString())).get(0));
			request.setAttribute("listMatiere",imat.ListMatiereByProf(Integer.parseInt(session.getAttribute("professeur_id").toString())) );
			request.getRequestDispatcher("ajouterAbsence.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/absenceData")) {
			request.setAttribute("listMatiere",imat.ListMatiereByProf(Integer.parseInt(session.getAttribute("professeur_id").toString())) );
			session.setAttribute("date",request.getParameter("date"));
			session.setAttribute("matiere",request.getParameter("matiere"));
			session.setAttribute("creneau",request.getParameter("creneau")); 
			request.setAttribute("etudiants",itud.listEtudiantByMatiere(imat.getMatiereByName(request.getParameter("matiere")).getId()));
			request.getRequestDispatcher("ajouterAbsence.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/addAbsence")) {
			String[] etudiantList=request.getParameterValues("listEtudiant");
			for(int i=0;i<etudiantList.length;i++) {
				Etudiant e=new Etudiant();
				e.setId(Integer.parseInt(etudiantList[i]));
				iAbsn.ajouter_absence(session.getAttribute("creneau").toString(),e,imat.getMatiereByName(session.getAttribute("matiere").toString()),Date.valueOf(session.getAttribute("date").toString()));
			}
			System.out.println(etudiantList[0]);
			//
		}
	}
}
