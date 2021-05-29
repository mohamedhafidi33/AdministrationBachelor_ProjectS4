package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Gender;
import beans.Professeur;
import dao.ExcelGenerator;
import dao.IMatiereDAO;
import dao.IMatiereImplDAO;
import dao.IProfesseurDAO;
import dao.IProfesseurImplDAO;
import dao.ISemestreDAO;
import dao.ISemestreImplDAO;

/**
 * Servlet implementation class ServletGestionProf
 */
@WebServlet(urlPatterns = { "/ajouterProf", "/addProf", "/afficherProfs", "/modifierProf", "/deleteProf",
		"/imprimerProfs","/sendSemestre" })
public class ServletGestionProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Professeur prof = new Professeur();
	IProfesseurDAO iprof = new IProfesseurImplDAO();
	IMatiereDAO imatiere = new IMatiereImplDAO();
	ISemestreDAO isem = new ISemestreImplDAO();
	ExcelGenerator excelG=new ExcelGenerator();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGestionProf() {
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
		System.out.print(request.getServletPath());

		if (request.getServletPath().equals("/ajouterProf")) {
			request.setAttribute("listMatiere", imatiere.listeMatiere());
			request.getRequestDispatcher("ajouterProf.jsp").forward(request, response);
		}

		if (request.getServletPath().equals("/addProf")) {
			if(!request.getParameter("excelList").isEmpty()) {
				//excelG.excelData(request.getParameter("excelList"));
				 for (Entry<Integer, List<String>> me : excelG.excelData(request.getParameter("excelList")).entrySet()) {
			            Professeur prof=new Professeur();
			            String[] matiereList = null;
			            Integer key = me.getKey();
			            List<String> values = me.getValue();
			            
			            System.out.println("Key: " + key);
			            System.out.print("Values: ");
			            
			            //for(int e=0;e<values.size();e++) {
			            if(key!=0) {
			            	prof.setNom(values.get(0));
			            	prof.setPrenom(values.get(1));
			            	System.out.println("hahowa le nom mn excel!!!!!!"+values.get(1));
			            	prof.setCin(values.get(2));
			            	prof.setEmail(values.get(3));
			            	prof.setNationalite(values.get(4));
			            	prof.setVille(values.get(5));
			            	prof.setProvince(values.get(6));
			            	prof.setSexe(Gender.valueOf(values.get(7)));
//			            	e=9;
//			            	for(int j=0;j<matiereList.length;j++) {
//			            	matiereList[j]=values.get(e);}
			               // System.out.printf("%s ", values.get(e));
			              //  }
			            	 iprof.ajouterProf(prof);
			            }
			           
//			            for(int i=0 ;i<matiereList.length;i++){
//							System.out.print("t*иииииииииии"+matiereList[i]);
//						iprof.addEnseignement(iprof.getIdProf(prof.getNom(), prof.getPrenom()),Integer.parseInt(matiereList[i]));
//						}
			            System.out.println();
			        }
			} else {
			prof.setNom(request.getParameter("nom"));
			prof.setPrenom(request.getParameter("prenom"));
			prof.setCin(request.getParameter("cin"));
			prof.setEmail(request.getParameter("email"));
			prof.setNationalite(request.getParameter("nationalite"));
			prof.setVille(request.getParameter("ville"));
			prof.setProvince(request.getParameter("province"));
			String[] matiereList=request.getParameterValues("matiereList");
			prof.setSexe(Gender.valueOf(request.getParameter("gender")));
			iprof.ajouterProf(prof);
			for(int i=0 ;i<matiereList.length;i++){
				System.out.print("t*иииииииииии"+matiereList[i]);
			iprof.addEnseignement(iprof.getIdProf(prof.getNom(), prof.getPrenom()),Integer.parseInt(matiereList[i]));
			}}
			request.getRequestDispatcher("/afficherProfs").forward(request, response);
		}

		if (request.getServletPath().equals("/afficherProfs")) {
			request.setAttribute("profs", iprof.listProfs());
			request.setAttribute("listSemestre", isem.listeSemestre());
			request.getRequestDispatcher("afficherProfs.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/modifierProf")) {
			prof.setId(Integer.parseInt(request.getParameter("id")));
			prof.setNom(request.getParameter("nom1"));
			prof.setPrenom(request.getParameter("prenom1"));
			prof.setCin(request.getParameter("cin1"));
			prof.setEmail(request.getParameter("email1"));
			prof.setNationalite(request.getParameter("nationalite1"));
			prof.setVille(request.getParameter("ville1"));
			prof.setProvince(request.getParameter("province1"));
			System.out.println(request.getParameter("email1"));
			prof.setSexe(Gender.valueOf(request.getParameter("gender1")));
			iprof.modifierProf(prof);
			request.getRequestDispatcher("/afficherProfs").forward(request, response);
		}
		if (request.getServletPath().equals("/deleteProf")) {
			prof.setId(Integer.parseInt(request.getParameter("id")));
			iprof.deleteEnseignement(Integer.parseInt(request.getParameter("id")));
			iprof.supprimerProf(prof);
			request.getRequestDispatcher("/afficherProfs").forward(request, response);
		}
		boolean printProfs = false;
		if (request.getServletPath().equals("/imprimerProfs")) {
			printProfs = true;
			request.setAttribute("listSemestre", isem.listeSemestre());
			request.setAttribute("printProfs", printProfs);
			request.setAttribute("profs", iprof.listProfs());
			this.getServletContext().getRequestDispatcher("/Print.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/sendSemestre")) {
			request.setAttribute("profs",iprof.listProfsBySemestre(isem.getIdSemestre(request.getParameter("semestre"))));
			request.getRequestDispatcher("/afficherProfs.jsp").forward(request, response);
		}
	}
}