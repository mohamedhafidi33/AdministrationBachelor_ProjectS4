package dao;

import java.util.List;

import beans.*;

public interface IEtudiantDAO {
Etudiant getEtudiant(User user);
List<Etudiant> listEtudiantByMatiere(int idMatiere);
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
