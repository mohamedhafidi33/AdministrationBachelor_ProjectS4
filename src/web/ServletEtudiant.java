package web;

import java.io.BufferedInputStream;
import beans.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.AnneeUniversitaire;
import beans.Doctype;
import beans.Document;
import beans.Etudiant;
import beans.Filiere;
import beans.Gender;
import beans.Schedule;
import beans.Session;
import dao.IAnneeUniversitaireImplDAO;
import dao.IDocumentDAO;
import dao.IDocumentImplDAO;
import dao.IEmploiImplDAO;
import dao.IEtudiantDAO;
import dao.IEtudiantImplDAO;
import dao.IFiliereImplDAO;
import dao.ISemestreImplDAO;

/**
 * Servlet implementation class ServletEtudiant
 */

@WebServlet(urlPatterns = { "/ajouterEtudiant", "/afficherEtudiant", "/ListEtudiant",
		"/supprimerEtudiant","/modifierEtudiant", "/editEtudiant", "/selectData", "/ajouterEmploi", "/addEmploi", "/tableEtudiant",
		"/afficherEmploi","/downloadPdf" ,"/supprimerEmploi","/modifierEmploi","/modifierEmploiSubmit"})
@MultipartConfig(maxRequestSize=1024*1024*5*5)


public class ServletEtudiant extends HttpServlet {

	Etudiant etudiant = new Etudiant();
	Schedule emploi = new Schedule();
	IEtudiantDAO etudiantDao = new IEtudiantImplDAO();
	InputStream inputStream = null;
	IDocumentDAO documentDao = new IDocumentImplDAO();
	Document document = new Document();
	IAnneeUniversitaireImplDAO iAnne = new IAnneeUniversitaireImplDAO();
	AnneeUniversitaire annee = new AnneeUniversitaire();
	Filiere filiere = new Filiere();
	IFiliereImplDAO filiereDao = new IFiliereImplDAO();
	ISemestreImplDAO semestreDao = new ISemestreImplDAO();
	IEmploiImplDAO emploiDao = new IEmploiImplDAO();
	Semestre semestre = new Semestre();
	//private StarDocs stardocs =null;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEtudiant() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		 //request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
		 if (request.getServletPath().equals("/ajouterEtudiant")) {
		 request.setAttribute("annees",iAnne.listAnnees());
		 request.getRequestDispatcher("/addStudent.jsp").forward(request, response); }
		 

		 
		doPost(request, response);
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String path = request.getServletPath();
		System.out.println("path : " + path);
		// TODO Auto-generated method stub
		if (request.getServletPath().equals("/ajouterEtudiant")) {

			String nom = request.getParameter("nom");
			System.out.println("hada nom f servlet " + nom);
			String prenom = request.getParameter("prenom");
			String cne = request.getParameter("cne");
			String cin = request.getParameter("cin");
			String email = request.getParameter("email");
			String dateNaissance = request.getParameter("dateNaissance");
			System.out.println("hady date naissance : " + dateNaissance);
			String dateInscription = request.getParameter("dateInscription");
			System.out.println("hady date d'inscription :" + dateInscription);
			String sexe = request.getParameter("gender");
			String etablissement = request.getParameter("etablissement");
			String lieuBac = request.getParameter("lieuBac");
			String lycee = request.getParameter("lycee");
			String nationalite = request.getParameter("nationalite");
			String province = request.getParameter("province");
			String lieuNaissance = request.getParameter("lieuNaissance");
			String ville = request.getParameter("ville");
			String nomFiliere = request.getParameter("filiere");
			String mention = request.getParameter("mention");
			String dateDebut = request.getParameter("dateDebut");
			System.out.println("this is the DATE OF THE DEBUT : " + dateDebut);
			String dateFin = request.getParameter("dateFin");
			String nomSemestre = request.getParameter("nomSemestre");

			Etudiant etudiant = new Etudiant();

			etudiant.setId(etudiant.getId());
			System.out.println("this is the student ID : " + etudiant.getId());
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

			// obtains the upload file part in this request
			Part filePart = request.getPart("certificat");
			if (filePart != null) {
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				// obtains input stream of the upload file
			}
			/*
			 * if(filePart.getName() == "certificat") {
			 * System.out.println("HADA HWA NAME : "+filePart.getName());
			 * document.setType(Doctype.bac);
			 * System.out.println("HADA HWA TYPE : "+document.getType()); }
			 * if(filePart.getName() == "attestation") {
			 * document.setType(Doctype.attestation); } if(filePart.getName() == "recu") {
			 * document.setType(Doctype.reçuPaiement); }
			 */
			document.setType(Doctype.bac);

			System.out.println("HADA HWA TYPE : " + document.getType());
			inputStream = filePart.getInputStream();

			int row = documentDao.uploadDocument(inputStream);
			if (row > 0) {
				System.out.println("file uploaded and saved into database");
			}

			etudiant.setMention(mention);
			filiere.setNom(nomFiliere);

			etudiantDao.selectByNomFil(nomFiliere);


			etudiantDao.saveEtudiant(etudiant);
			filiereDao.selectByNomFil(nomFiliere);

			Date dateDebut1 = Date.valueOf(dateDebut);
			annee.setDate_debut(dateDebut1);
			Date dateFin1 = Date.valueOf(dateFin);
			annee.setDate_fin(dateFin1);

			semestreDao.saveSemestre(nomSemestre, filiereDao.selectByNomFil(nomFiliere));

			System.out.println("this is the id of the filiere : " + semestreDao.searchByNom(nomSemestre));

			System.out.println("this is the id of the filiere : " + etudiantDao.selectByNomFil(nomFiliere));

			etudiantDao.getIdEtudiantByCne(cne);
			iAnne.selectByDateDebut(dateDebut1, dateFin1);
			etudiantDao.addInscription(etudiantDao.getIdEtudiantByCne(cne),
					iAnne.selectByDateDebut(dateDebut1, dateFin1));
			System.out.println("these are the years : " + dateDebut1 + "," + dateFin1);

			System.out.println("hnnaaaaa");
			response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEtudiant");
			
		}

		else if (request.getServletPath().equals("/afficherEtudiant")) {

			List<Etudiant> etudiants = etudiantDao.listEtudiants();
			request.setAttribute("etudiants", etudiants);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListEtudiant.jsp");
			dispatcher.forward(request, response);
		}

		else if (request.getServletPath().equals("/supprimerEtudiant")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			etudiantDao.deleteEtudiant(id);
			response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEtudiant");

		} 
		else if (request.getServletPath().equals("/modifierEtudiant")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			Etudiant etudiant  = etudiantDao.getEtudiant(id);
			request.setAttribute("etudiant",etudiant);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/modifierEtudiant.jsp");
			dispatcher.forward(request, response);
		}
		
		
		else if (request.getServletPath().equals("/editEtudiant")) {

			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			System.out.println("hada nom f servlet " + nom);
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
		
			String mention = request.getParameter("mention");

			Etudiant etudiant = new Etudiant();
			etudiant.setId(id);
			
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
			etudiant.setMention(mention);
			etudiant.setEtablissement(etablissement);

			etudiantDao.updateEtudiant(etudiant);
			response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEtudiant");

		}

		else if (request.getServletPath().equals("/selectData")) {

			String dateDebut = request.getParameter("dateDebut");
			String dateFin = request.getParameter("dateFin");
			String nomSemestre = request.getParameter("nomSemestre");
			System.out.println("name of semester  : " + nomSemestre);
			String nomFiliere = request.getParameter("filiere");
			Date dateDebut1 = Date.valueOf(dateDebut);
			System.out.println("date debut IISSSS " + dateDebut1);
			Date dateFin1 = Date.valueOf(dateFin);
			System.out.println("date debut IISSSS " + dateFin1);

			System.out.println("ID semestre : " + semestreDao.searchByNom(nomSemestre));
			System.out.println("ID anneee : " + iAnne.selectByDateDebut(dateDebut1, dateFin1));
			System.out.println("ID filiere : " + etudiantDao.selectByNomFil(nomFiliere));
			List<Etudiant> listEt = etudiantDao.listParFilSeUniv(semestreDao.searchByNom(nomSemestre),
					iAnne.selectByDateDebut(dateDebut1, dateFin1), etudiantDao.selectByNomFil(nomFiliere));
			System.out.println("liste etudiants : " + listEt);
			request.setAttribute("etudiants", listEt);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListEtudiant.jsp");
			dispatcher.forward(request, response);

		} else if (request.getServletPath().equals("/ajouterEmploi")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/addSchedule.jsp");
			dispatcher.forward(request, response);

		}

		else if (request.getServletPath().equals("/addEmploi")) {
			Part partsemestre = request.getPart("nomSemestre");
			String semestre = getValeur(partsemestre);

			System.out.println("hada nom f servlet " + semestre);
			Part partsession = request.getPart("session");
			String session2   =getValeur(partsession);
			
			Part dateDebutParte = request.getPart("dateDebut");			
			String dateDebut1 = getValeur(dateDebutParte);
			
			Part dateFin1Parte = request.getPart("dateFin");	
			String dateFin1 = getValeur(dateFin1Parte);
			System.out.println("Date est : "+dateFin1);
			
			Part nomEmploiPart = request.getPart("nomEmploi");
			String nomEmploi = getValeur(nomEmploiPart);

			
			Date dateeDebut = Date.valueOf(dateDebut1);
			
			
			Date dateeFin = Date.valueOf(dateFin1);

			Part filePart = request.getPart("emploiFile");

			semestreDao.searchByNom(semestre);
			iAnne.selectByDateDebut(dateeDebut, dateeFin);

			if (filePart != null) {

				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				inputStream = filePart.getInputStream();
				System.out.println("semester id : " + semestreDao.searchByNom(semestre));

				emploiDao.addIdsSchedule(nomEmploi, Session.valueOf(session2),
						iAnne.selectByDateDebut(dateeDebut, dateeFin), semestreDao.searchByNom(semestre), inputStream);
				response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEmploi");

			}
		}

		else if (request.getServletPath().equals("/tableEtudiant")) {
			List<Etudiant> etudiants = etudiantDao.listEtudiants();
			request.setAttribute("etudiants", etudiants);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/tablesEtudiants.jsp");
			dispatcher.forward(request, response);

		}

		else if (request.getServletPath().equals("/afficherEmploi")) {

			List<Schedule> emplois = emploiDao.listEmplois();
			request.setAttribute("emplois", emplois);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListEmploi.jsp");
			dispatcher.forward(request, response);

		} 
		else 	if(request.getServletPath().equals("/downloadPdf")){
			 System.out.println("dssdds");
				int id = Integer.parseInt(request.getParameter("idPdf"));
				Schedule schedule = emploiDao.selectById(id);
				/**
				 * make byte
				 * */
				BufferedInputStream bis = new BufferedInputStream(schedule.getEmploiFile());
				byte tab[] = bis.readAllBytes();
				bis.close();
				response.setContentType("application/pdf");
				ServletOutputStream out = response.getOutputStream();
				out.write(tab);
				out.close();
		}
		
		else if (request.getServletPath().equals("/supprimerEmploi")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			emploiDao.deleteById(id);
			response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEmploi");

		}
		else if (request.getServletPath().equals("/modifierEmploi")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			
			System.out.println("emploi ID : "+id);
			Schedule emploi  = emploiDao.selectById(id);
			request.setAttribute("emploi", emploi);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/modifierEmploi.jsp");
			dispatcher.forward(request, response);
			
		}
		
		else if (request.getServletPath().equals("/modifierEmploiSubmit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			emploi.setId(id);
			emploi.setNomEmploi(request.getParameter("nomEmploi"));
			Part filePart = request.getPart("emploiFile");
		    emploi.setEmploiFile(filePart.getInputStream());
		    emploi.setSession(Session.valueOf(request.getParameter("session")));
		    System.out.println("LA SESSION EST :"+Session.valueOf(request.getParameter("session")));
			
			emploiDao.updateEmploi(emploi); 
			response.sendRedirect("/AdministrationBachelor_ProjectS4/afficherEmploi");
		}

	}
	private String getValeur( Part part ) throws IOException {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( part.getInputStream(), "UTF-8" ) );
	    StringBuilder valeur = new StringBuilder();
	    char[] buffer = new char[1024];
	    int longueur = 0;
	    while ( ( longueur = reader.read( buffer ) ) > 0 ) {
	        valeur.append( buffer, 0, longueur );
	    }
	    return valeur.toString();
	}
}