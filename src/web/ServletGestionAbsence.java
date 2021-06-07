package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Absence;
import beans.Etudiant;
import dao.IAbsenceDAO;
import dao.IAbsenceImplDAO;
import dao.IEtudiantDAO;
import dao.IEtudiantImplDAO;
import dao.IFiliereDAO;
import dao.IFiliereImplDAO;
import dao.IMatiereDAO;
import dao.IMatiereImplDAO;
import dao.SendAtt;

/**
 * Servlet implementation class ServletGestionAbsence
 */
@WebServlet(urlPatterns = { "/AjouterAbsence", "/absenceData", "/addAbsence", "/afficheAbsence", "/getAbsenceData",
		"/modifierAbsence", "/deleteAbsence", "/envoiEmail","/MesAbsences","/MatiereAbsence" })
public class ServletGestionAbsence extends HttpServlet {
	IMatiereDAO imat = new IMatiereImplDAO();
	IFiliereDAO ifil = new IFiliereImplDAO();
	IEtudiantDAO itud = new IEtudiantImplDAO();
	IAbsenceDAO iAbsn = new IAbsenceImplDAO();
	SendAtt snd = new SendAtt();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGestionAbsence() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (request.getServletPath().equals("/AjouterAbsence")) {
			boolean prof = false;
			boolean admin = false;
			if (session.getAttribute("professeur_id") != null) {
				prof = true;
				request.setAttribute("listMatiere",
						imat.ListMatiereByProf(Integer.parseInt(session.getAttribute("professeur_id").toString())));
				request.setAttribute("prof", prof);
			}
			if (session.getAttribute("admin") != null) {
				admin = true;
				request.setAttribute("listMatiere", imat.listeMatiere());
				request.setAttribute("admin",admin);
			}
			request.getRequestDispatcher("ajouterAbsence.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/absenceData")) {
			if (session.getAttribute("professeur_id") != null) {
				boolean prof = true;
				request.setAttribute("prof", prof);
				request.setAttribute("listMatiere",
						imat.ListMatiereByProf(Integer.parseInt(session.getAttribute("professeur_id").toString())));
			}
			if (session.getAttribute("admin") != null) {
				request.setAttribute("listMatiere", imat.listeMatiere());
				boolean admin = true;
				request.setAttribute("admin", admin);
			}
			session.setAttribute("date", request.getParameter("date"));
			session.setAttribute("matiere", request.getParameter("matiere"));
			session.setAttribute("creneau", request.getParameter("creneau"));
			System.out.println(request.getParameter("matiere"));
			System.out.println(imat.getMatiereByName(request.getParameter("matiere")).getId());
			System.out.println("this is the Id "+itud.listEtudiantByMatiere(imat.getMatiereByName(request.getParameter("matiere")).getId()).get(0).getNom());
			request.setAttribute("etudiants",
					itud.listEtudiantByMatiere(imat.getMatiereByName(request.getParameter("matiere")).getId()));
			request.getRequestDispatcher("ajouterAbsence.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/addAbsence")) {
			String[] etudiantList = request.getParameterValues("listEtudiant");
			for (int i = 0; i < etudiantList.length; i++) {
				Etudiant e = new Etudiant();
				e.setId(Integer.parseInt(etudiantList[i]));
				iAbsn.ajouter_absence(session.getAttribute("creneau").toString(), e,
						imat.getMatiereByName(session.getAttribute("matiere").toString()),
						Date.valueOf(session.getAttribute("date").toString()));
			}
			if (session.getAttribute("professeur_id") != null) {
				request.getRequestDispatcher("HomeProf.jsp").forward(request, response);
			}
			if (session.getAttribute("admin") != null) {
				request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
			}
		}
		if (request.getServletPath().equals("/getAbsenceData")) {
			session.setAttribute("matiere", request.getParameter("matiere"));
			boolean admin = true;
			request.setAttribute("admin", admin);
			request.setAttribute("etudiants",
					itud.listEtudiantByMatiere(imat.getMatiereByName(request.getParameter("matiere")).getId()));
			request.setAttribute("listMatiere", imat.listeMatiere());
			request.setAttribute("absence", iAbsn
					.listAbsenceByMatiere(imat.getMatiereByName(session.getAttribute("matiere").toString()).getId()));
			request.getRequestDispatcher("afficherAbsence.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/afficheAbsence")) {
			request.setAttribute("listMatiere", imat.listeMatiere());
			request.getRequestDispatcher("afficherAbsence.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/modifierAbsence")) {
			System.out.println(request.getParameter("argument"));
			FileInputStream file = new FileInputStream(new File(request.getParameter("argument")));
			iAbsn.modifierAbsence(Integer.parseInt(request.getParameter("id")), file);
			request.getRequestDispatcher("/afficheAbsence").forward(request, response);
		}
		if (request.getServletPath().equals("/deleteAbsence")) {
			Absence absence = new Absence();
			absence.setId(Integer.parseInt(request.getParameter("id")));
			iAbsn.supprimer_absence(absence);
			request.getRequestDispatcher("/afficheAbsence").forward(request, response);
		}
		if (request.getServletPath().equals("/envoiEmail")) {
			snd.sendEmailAtt(request.getParameter("email"), request.getParameter("file"), request.getParameter("text"));
			request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/MesAbsences")) {
			//request.setAttribute("mesAbsences",iAbsn.listAbsenceByEtudiant(Integer.parseInt(session.getAttribute("etudiant_id").toString())));
			request.setAttribute("listMatiere", imat.ListMatiereByEtudiant(Integer.parseInt(session.getAttribute("etudiant_id").toString())));
			request.getRequestDispatcher("MesAbsences.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/MatiereAbsence")) {
			request.setAttribute("mesAbsences",iAbsn.listAbsenceByEtudiant(Integer.parseInt(session.getAttribute("etudiant_id").toString()),imat.getMatiereByName(request.getParameter("matiere").toString()).getId()));
			request.setAttribute("listMatiere", imat.ListMatiereByEtudiant(Integer.parseInt(session.getAttribute("etudiant_id").toString())));
			request.getRequestDispatcher("/MesAbsences").forward(request, response);
		}
	}
}