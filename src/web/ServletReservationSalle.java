package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Creneau;
import beans.Salle;
import beans.Typesalle;
import dao.ISalleDAO;
import dao.ISalleImplDAO;

/**
 * Servlet implementation class ServletReservationSalle
 */
@WebServlet(urlPatterns = { "/ajouterSalle","/addSalle","/afficheSalles" })
public class ServletReservationSalle extends HttpServlet {
	Salle salle=new Salle();
	ISalleDAO isalle=new ISalleImplDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReservationSalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("/ajouterSalle.jsp").forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print(request.getServletPath());
		if(request.getServletPath().equals("/addSalle")) {
			System.out.println("nta hna");
			String description=request.getParameter("description");
			int numero = Integer.parseInt(request.getParameter("numero"));
			Typesalle typeSalle=Typesalle.valueOf(request.getParameter("typesalle"));
			System.out.println(description);
			
			salle.setDescription(description);
			salle.setNumero(numero);
			salle.setOccupation(false);
			salle.setTypesalle(typeSalle);
			isalle.ajouterSalle(salle);
			System.out.println("salle bien ajoutée");
		}
		else if (request.getServletPath().equals("/reserver")) {
			Creneau creneau=Creneau.valueOf(request.getParameter("crenau"));
			//Date date=(Date)request.getParameter("date");
		}
		else if(request.getServletPath().equals("/supprimerSalle")) {
			
		}
		else if (request.getServletPath().equals("/afficheSalles")) {
			
			request.setAttribute("salles", isalle.listsalles());
			List <Salle> salles = (List<Salle>)request.getAttribute("salles");
			System.out.println("hadi hahiya: "+salles.get(0).getNumero());
			this.getServletContext().getRequestDispatcher("/afficheSalles.jsp").forward(request, response);
		}
	}
}
