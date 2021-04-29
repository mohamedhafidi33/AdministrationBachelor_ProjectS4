package dao;

import java.util.List;

import beans.Salle;

public interface ISalleDAO {
	public void ajouterSalle(Salle salle);
	public void supprimerSalle(Salle salle);
	public List<Salle> listsalles();
	public Salle getSalleById(int id);
	public List<Salle> disponibleSalles();
}
