package web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.text.ParseException;

import java.sql.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import java.text.SimpleDateFormat;

import beans.*;
import dao.*;
/**
 * Servlet implementation class ServletEtudiant
 */

@WebServlet(urlPatterns = {"/ajouterEtudiant","/addStudent","/afficherEtudiant","/ListEtudiant","/supprimerEtudiant","/editEtudiant"})
@MultipartConfig(maxFileSize = 16177215)
public class ServletEtudiant extends HttpServlet {
	
	Etudiant etudiant = new Etudiant();
	IEtudiantDAO etudiantDao=new IEtudiantImplDAO();
	InputStream inputStream = null;
	IDocumentDAO documentDao=new IDocumentImplDAO();
	Document document = new Document();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEtudiant() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
		if (request.getServletPath().equals("/ajouterEtudiant")) {
			request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.print(request.getServletPath());
		// TODO Auto-generated method stub
		if (request.getServletPath().equals("/ajouterEtudiant")) {
			
			
		
			String nom = request.getParameter("nom");
			System.out.println("hada nom f servlet "+nom); 
			String prenom = request.getParameter("prenom");
			String cne = request.getParameter("cne");
			String cin = request.getParameter("cin");
			String email = request.getParameter("email");
		    String dateNaissance = request.getParameter("dateNaissance");
		    System.out.println("hady date naissance : "+dateNaissance);
			String dateInscription = request.getParameter("dateInscription");
			System.out.println("hady date d'inscription :"+dateInscription);
			String sexe = request.getParameter("gender");
			String etablissement = request.getParameter("etablissement");
			String lieuBac = request.getParameter("lieuBac");
			String lycee = request.getParameter("lycee");
			String nationalite = request.getParameter("nationalite");
			String province = request.getParameter("province");
			String lieuNaissance = request.getParameter("lieuNaissance");
			String ville = request.getParameter("ville");
			String nomFiliere = request.getParameter("filiere");
			String mention  = request.getParameter("mention");
			

			Etudiant etudiant =new Etudiant();
			Filiere filiere = new Filiere();
			
			etudiant.setId(etudiant.getId());
			System.out.println("this is the student ID : "+etudiant.getId());
			etudiant.setNom(nom);
			etudiant.setPrenom(prenom);
			etudiant.setCne(cne);
			etudiant.setCin(cin);
			etudiant.setEmail(email);
			
			Date dateNaissance1 = Date.valueOf(dateNaissance);
			etudiant.setDateNaissance(dateNaissance1);
			Date dateInscription1 = Date.valueOf(dateInscription);
			etudiant.setDateInscription(dateInscription1);
			etudiant.setSexe(Gender.valueOf(sexe));
			etudiant.setEtablissement(etablissement);
			etudiant.setLieuBac(lieuBac);
			etudiant.setLieuNaissance(lieuNaissance);
			etudiant.setLycee(lycee);
			etudiant.setNationalite(nationalite);
			etudiant.setProvince(province);
			etudiant.setVille(ville);
			
			
			//obtains the upload file part in this request 
			Part filePart = request.getPart("certificat");
			if(filePart != null) {
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());
				
				//obtains input stream of the upload file 
			}
				/*if(filePart.getName() == "certificat") {
					System.out.println("HADA HWA NAME : "+filePart.getName());
					document.setType(Doctype.bac);
					System.out.println("HADA HWA TYPE : "+document.getType());
				}
				if(filePart.getName() == "attestation") {
					document.setType(Doctype.attestation);
				}
				if(filePart.getName() == "recu") {
					document.setType(Doctype.reçuPaiement);
				}*/
			    document.setType(Doctype.bac);
			    
			    System.out.println("HADA HWA TYPE : "+document.getType());
				inputStream = filePart.getInputStream();
			
			int row = documentDao.uploadDocument(inputStream );
			if(row >0) {
			      System.out.println("file uploaded and saved into database");
			}
						
			
			etudiant.setMention(mention);
			filiere.setNom(nomFiliere);
			
		
			etudiantDao.saveEtudiant(etudiant);
			System.out.println("hnnaaaaa"); 
			response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEtudiant");
			
			
		}
	
	if (request.getServletPath().equals("/afficherEtudiant")) {
		
		List <Etudiant> etudiants = etudiantDao.listEtudiants();
		request.setAttribute("etudiants", etudiants);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListEtudiant.jsp");
		dispatcher.forward(request, response);
	}
	
	if (request.getServletPath().equals("/supprimerEtudiant")) {
		int id = Integer.parseInt(request.getParameter("id").trim());
		etudiantDao.deleteEtudiant(id);
		response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEtudiant");
		
	}
	if (request.getServletPath().equals("/editEtudiant")) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		System.out.println("hada nom f servlet "+nom); 
		String prenom = request.getParameter("prenom");
		String cne = request.getParameter("cne");
		String cin = request.getParameter("cin");
		String email = request.getParameter("email");
		String etablissement = request.getParameter("etablissement");
		String lycee = request.getParameter("lycee");
		String nationalite = request.getParameter("nationalite");
		String province = request.getParameter("province");
		String lieuNaissance = request.getParameter("lieuNaissance");
		String ville = request.getParameter("ville");
		String nomFiliere = request.getParameter("filiere");
		String mention  = request.getParameter("mention");
		
		
        Etudiant etudiant  = new Etudiant();
        etudiant.setId(etudiant.getId());
		System.out.println("this is the student ID : "+etudiant.getId());
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setCne(cne);
		etudiant.setCin(cin);
		etudiant.setEmail(email);
		
		
		etudiant.setLieuNaissance(lieuNaissance);
		etudiant.setLycee(lycee);
		etudiant.setNationalite(nationalite);
		etudiant.setProvince(province);
		etudiant.setVille(ville);
        
        
        etudiantDao.updateEtudiant(etudiant);
        
        response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEtudiant");
 
	}
	/*if (request.getServletPath().equals("/EmploiEtudiant")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/schedule.jsp");
	
	}*/
	
	
		}
}