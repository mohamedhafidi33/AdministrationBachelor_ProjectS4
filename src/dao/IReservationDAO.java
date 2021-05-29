package dao;

import java.util.Date;
import java.util.List;

import beans.*;

public interface IReservationDAO {
	void ajouterReservation(Reservation reservation);
	void supprimerReservation(Reservation reservation);
	List<Reservation> listreseRvations();
	
	List<Reservation> ReservationByProf(Professeur prof);
	//void supprimerParSalle(Reservation reservation);
	void supprimerParSalle(Salle salle);
}
