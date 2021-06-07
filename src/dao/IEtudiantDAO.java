package dao;

import java.io.Serializable;

import beans.AnneeUniversitaire;
import java.util.List;
import java.sql.Date;
import beans.*;
import beans.Etudiant;

public interface IEtudiantDAO  extends Serializable{
	
	void saveEtudiant(Etudiant etudiant);
	Etudiant getEtudiant(int id);
	public int getIdEtudiantByCne(String cne);
	
	
	public List<Etudiant> listEtudiants();

	Etudiant updateEtudiant(Etudiant etudiant); 
	void deleteEtudiant(int id );
	void addInscription(int etudiant_id, int annee_id );
	public int selectByNomFil(String nomFiliere);
	public void addFiliereId(int filiere_id);
	
	public List<Etudiant> listParFilSeUniv(int idSem, int idAnnee, int idFil);
	
	
}
