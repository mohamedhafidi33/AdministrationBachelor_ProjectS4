package dao;
import beans.*;

public interface IProfesseurDAO {
	void ajouterProfesseur (Professeur Prof,User userP);
	void modifierProfesseur (Professeur Prof);
	void supprimerProfesseur(int id);
	

}
