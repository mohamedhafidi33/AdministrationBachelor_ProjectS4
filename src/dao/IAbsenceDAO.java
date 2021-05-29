package dao;

import java.sql.Date;

import beans.*;

public interface IAbsenceDAO {
	void ajouter_absence(String c, Etudiant e, Matiere m,Date date);
	void supprimer_absence(ME_Absence a);
}
