package dao;

import java.util.List;

import beans.Filiere;
import beans.Matiere;

public interface IMatiereDAO {
	public List<Matiere> listeMatiere();
	
	List<Matiere> ListMatiereByProf(int idprof);

	Matiere getMatiereByName(String name);
}
