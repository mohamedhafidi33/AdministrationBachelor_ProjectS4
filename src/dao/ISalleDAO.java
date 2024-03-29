package dao;

import java.sql.Date;
import java.util.List;

import beans.Reservation;
import beans.Salle;

public interface ISalleDAO {
	public void ajouterSalle(Salle salle);
	public void supprimerSalle(Salle salle);
	public List<Salle> listsalles();
	public Salle getSalleById(int id);
	public List<Salle> disponibleSalles();
	void modifierSalle(Salle salle);
	
	List<Salle> listSallebyDate(Date date);
//	List dispoParCreneau1(Date date);
	Boolean dispoParCreneau1(Reservation reservation);
}
