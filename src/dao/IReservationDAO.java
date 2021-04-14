package dao;

import java.util.Date;

import beans.*;

public interface IReservationDAO {
	void ajouter_reservation(Salle s,Professeur p,Creneau c,Date d);
	void supprimer_reservation(Reservation r);
	Reservation chercher_reservation(Reservation R);
}
