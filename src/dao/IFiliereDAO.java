package dao;

import java.util.List;

import beans.Filiere;

public interface IFiliereDAO {
	public Filiere getFiliereByName(String name) ;

	public void saveFiliere(String nomFiliere);

	List<Filiere> listeFiliere();
}
