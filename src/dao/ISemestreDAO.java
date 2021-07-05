package dao;

import java.util.List;

import beans.Matiere;
import beans.Semestre;

public interface ISemestreDAO {

	List<Semestre> listeSemestre();

	int getIdSemestre(String nomSemestre);

	void saveSemestre(String nomSemestre, int filiere_id );
	public int searchByNom (String nomSemestre);

}
