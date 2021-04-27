package dao;

import beans.*;

public interface IEtudiantDAO {
void ajouter_etudiant(Etudiant e,User u);
void supprimer_etudiant(Etudiant e);
Etudiant getEtudiant(User user);
}
