package web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Creneau;
import beans.Professeur;
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
@WebServlet(urlPatterns = { "/ajouterSalle", "/addSalle", "/afficheSalles", "/reserverSalle", "/reserver",
		"/deleteSalle", "/sendDate", "/modifierSalle", "/SallesReserves", "/libererSalle" })
public class ServletReservationSalle extends HttpServlet {
	Date datum;
	Salle salle = new Salle();
	ISalleDAO isalle = new ISalleImplDAO();
	IReservationDAO irsv = new IReservationImplDAO();
	IProfesseurDAO iprof = new IProfesseurImplDAO();
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
			Salle salle = new Salle();
			salle.setId(Integer.parseInt(request.getParameter("id")));
			salle.setNumero(Integer.parseInt(request.getParameter("numero1")));
			salle.setDescription(request.getParameter("description1"));
			System.out.println("description " + request.getParameter("description"));
			salle.setTypesalle(Typesalle.valueOf(request.getParameter("typesalle1")));
			isalle.modifierSalle(salle);
			this.getServletContext().getRequestDispatcher("/afficheSalles").forward(request, response);
		}

		else if (request.getServletPath().equals("/afficheSalles")) {
			request.setAttribute("salles", isalle.listsalles());
			this.getServletContext().getRequestDispatcher("/afficheSalles.jsp").forward(request, response);
		}

		else if (request.getServletPath().equals("/sendDate")) {
			System.out.println("hahowa  date " + request.getParameter("date"));
			if (isalle.listSallebyDate(Date.valueOf(request.getParameter("date"))).isEmpty()) {
				this.getServletContext().getRequestDispatcher("/reserverSalle").forward(request, response);
			} else {
				datum = Date.valueOf(request.getParameter("date"));
				session.setAttribute("datum", datum);
				List<Salle> salles = new ArrayList<Salle>();
				salles = isalle.disponibleSalles();
				for (int i = 0; i < isalle.listSallebyDate(Date.valueOf(request.getParameter("date"))).size(); i++) {
					salles.add(isalle.listSallebyDate(Date.valueOf(request.getParameter("date"))).get(i));
				}
				request.setAttribute("salles", salles);
				this.getServletContext().getRequestDispatcher("/reserverSalle.jsp").forward(request, response);
			}
		}

		else if (request.getServletPath().equals("/reserver")) {
			session.getAttribute("professeur_id");
			Reservation reservation = new Reservation();
			reservation.setSalle(isalle.getSalleById(Integer.parseInt(request.getParameter("id"))));
			if (request.getParameter("creneau").equals("C1")) {
				System.out.println(request.getParameter("creneau"));
				reservation.setCrenau(Creneau.C1);
			} else if (request.getParameter("creneau").equals("C2")) {
				reservation.setCrenau(Creneau.C2);
				System.out.println(request.getParameter("creneau"));
			}  else if (request.getParameter("creneau").equals("C3")) {
				System.out.println("creneau3********************************");
				reservation.setCrenau(Creneau.C3);
			}  else if (request.getParameter("creneau").equals("C4")){
				System.out.println("creneau4********************************");
				reservation.setCrenau(Creneau.C4);
			}
			System.out.println("here is the date" + session.getAttribute("datum"));
			reservation.setDate(datum);
			reservation.setProfesseur(
					iprof.getProfById(Integer.parseInt(session.getAttribute("professeur_id").toString())));
			//irsv.ajouterReservation(reservation);
			System.out.println("Done !!!!!!!!!!!!!!");
			this.getServletContext().getRequestDispatcher("/SallesReserves").forward(request, response);
		}

		else if (request.getServletPath().equals("/deleteSalle")) {
			System.out.println("you are deleting");
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("you are deleting" + id);
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
			this.getServletContext().getRequestDispatcher("/afficheSalles").forward(request, response);
		}
		if (request.getServletPath().equals("/SallesReserves")) {
			Professeur prof = new Professeur();
			List<Salle> salles = new ArrayList<Salle>();
			prof.setId(Integer.parseInt(session.getAttribute("professeur_id").toString()));
			for (int i = 0; i < irsv.ReservationByProf(prof).size(); i++) {
				salles.add(irsv.ReservationByProf(prof).get(i).getSalle());
			}
			request.setAttribute("reservs", irsv.ReservationByProf(prof));
			request.setAttribute("salles", salles);
			this.getServletContext().getRequestDispatcher("/SallesReserves.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/libererSalle")) {
			Salle salle = new Salle();
			salle.setId(Integer.parseInt(request.getParameter("id")));
			salle.setNumero(Integer.parseInt(request.getParameter("numero")));
			salle.setDescription(request.getParameter("description"));
			salle.setTypesalle(Typesalle.valueOf(request.getParameter("typesalle")));
			irsv.supprimerParSalle(salle);
			this.getServletContext().getRequestDispatcher("/SallesReserves").forward(request, response);
		}
	}
}
