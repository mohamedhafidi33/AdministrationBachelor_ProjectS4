package web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Creneau;
import beans.Reservation;
import beans.Salle;
import beans.Typesalle;
import dao.IProfesseurDAO;
import dao.IProfesseurImplDAO;
import dao.IReservationDAO;
import dao.IReservationImplDAO;
import dao.ISalleDAO;
import dao.ISalleImplDAO;

/**
 * Servlet implementation class ServletReservationSalle
 */
@WebServlet(urlPatterns = { "/ajouterSalle", "/addSalle", "/afficheSalles", "/reserverSalle", "/reserver","/deleteSalle","/sendDate","/modifierSalle" })
public class ServletReservationSalle extends HttpServlet {
	String datum="";
	Salle salle = new Salle();
	ISalleDAO isalle = new ISalleImplDAO();
	IReservationDAO irsv=new IReservationImplDAO();
	IProfesseurDAO iprof=new IProfesseurImplDAO();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletReservationSalle() {
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
		if (request.getServletPath().equals("/ajouterSalle")) {
			request.getRequestDispatcher("/ajouterSalle.jsp").forward(request, response);
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.print(request.getServletPath());
		if (request.getServletPath().equals("/addSalle")) {
			System.out.println("nta hna");
			String description = request.getParameter("description");
			int numero = Integer.parseInt(request.getParameter("numero"));
			Typesalle typeSalle = Typesalle.valueOf(request.getParameter("typesalle"));
			System.out.println(description);
			salle.setDescription(description);
			salle.setNumero(numero);
			salle.setOccupation(false);
			salle.setTypesalle(typeSalle);
			isalle.ajouterSalle(salle);
			System.out.println("salle bien ajoutée");
			this.getServletContext().getRequestDispatcher("/afficheSalles").forward(request, response);
		} 
		
		
		
		
		else if (request.getServletPath().equals("/reserverSalle")) {
			request.setAttribute("salles", isalle.disponibleSalles());
			this.getServletContext().getRequestDispatcher("/reserverSalle.jsp").forward(request, response);
		}
		
		
		
		
		else if (request.getServletPath().equals("/modifierSalle")) {
			Salle salle=new Salle();
			salle.setId(Integer.parseInt(request.getParameter("id")));
			salle.setNumero(Integer.parseInt(request.getParameter("numero")));
			salle.setDescription(request.getParameter("description"));
			salle.setTypesalle(Typesalle.valueOf(request.getParameter("typesalle")));
			isalle.modifierSalle(salle);
			this.getServletContext().getRequestDispatcher("/afficheSalles").forward(request, response);
		}
		
		
		
		else if (request.getServletPath().equals("/afficheSalles")) {
			request.setAttribute("salles", isalle.listsalles());
			this.getServletContext().getRequestDispatcher("/afficheSalles.jsp").forward(request, response);
		}
		
		
		
		
		else if(request.getServletPath().equals("/sendDate")) {
			if(isalle.listSallebyDate(Date.valueOf(request.getParameter("date"))).isEmpty()){this.getServletContext().getRequestDispatcher("/reserverSalle.jsp").forward(request, response);}
				else {
			datum= request.getParameter("date");
			request.setAttribute("salles",isalle.listSallebyDate(Date.valueOf(request.getParameter("date"))));
			this.getServletContext().getRequestDispatcher("/reserverSalle.jsp").forward(request, response);}
		}
		
		
		
		
		else if (request.getServletPath().equals("/reserver")) {
			session.getAttribute("professeur_id");
			Reservation reservation=new Reservation();
			reservation.setSalle(isalle.getSalleById(Integer.parseInt(request.getParameter("id"))));
			reservation.setCrenau(Creneau.valueOf(request.getParameter("creneau")));
			System.out.println("here is the date"+datum);
			reservation.setDate(Date.valueOf(datum));			
			reservation.setProfesseur(iprof.getProfById(Integer.parseInt(session.getAttribute("professeur_id").toString())));
			irsv.ajouterReservation(reservation);
			System.out.println("Done !!!!!!!!!!!!!!");
		}
		
		
		
		else if (request.getServletPath().equals("/deleteSalle")) {
			System.out.println("you are deleting");
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println("you are deleting"+id);
			String description = request.getParameter("description");
			int numero = Integer.parseInt(request.getParameter("numero"));
			Typesalle typeSalle = Typesalle.valueOf(request.getParameter("typesalle"));
			salle.setId(id);
			salle.setDescription(description);
			salle.setNumero(numero);
			salle.setOccupation(false);
			salle.setTypesalle(typeSalle);
			irsv.supprimerParSalle(salle);
			isalle.supprimerSalle(salle);
			
		}
	}
}
