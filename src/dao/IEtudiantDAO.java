package dao;

import java.io.Serializable;
import java.util.List;

import beans.*;
import beans.Etudiant;

public interface IEtudiantDAO  extends Serializable{
	
	void saveEtudiant(Etudiant etudiant);
	Etudiant getEtudiant(int id);
	public List<Etudiant> listEtudiants();

	Etudiant updateEtudiant(Etudiant etudiant);
	void deleteEtudiant(int id );

}
