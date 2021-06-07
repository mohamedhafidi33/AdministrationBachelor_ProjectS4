package dao;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import beans.*;

public interface IAbsenceDAO {
	
	//List<Absence> listAbsence();
	List<Absence> listAbsenceByMatiere(int idmat);
	void supprimer_absence(Absence a);
	void ajouter_absence(String c, Etudiant e, Matiere m, Date date);
	void modifierAbsence(int absence_Id,InputStream file);
	List<Absence> listAbsenceByEtudiant(int idetu,int idmat);
}
