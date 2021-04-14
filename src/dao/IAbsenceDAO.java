package dao;

import beans.*;

public interface IAbsenceDAO {
	void ajouter_absence(Absence a, Etudiant e, Matiere m);
	void supprimer_absence(ME_Absence a);
}
