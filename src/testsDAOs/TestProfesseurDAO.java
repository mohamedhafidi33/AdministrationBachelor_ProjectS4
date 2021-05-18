package testsDAOs;

import java.util.List;

import beans.*;
import dao.IEtudiantImplDAO;
import util.HibernateUtil;
import beans.Etudiant;
import beans.Typesalle;
import dao.IProfesseurImplDAO;

public class TestProfesseurDAO {
	public static void main(String[] args) {
		IProfesseurImplDAO profDao = new IProfesseurImplDAO ();
		
		//add student 
		Professeur prof = new Professeur( "abra","cadavra");
		User user=new User ("asmae","hafida");
		profDao.ajouterProfesseur(prof,user);
		
		Professeur prof1=new Professeur("hafida","lafkih");
		profDao.ajouterProfesseur(prof1,user);

		
		
		
		// update student
		Professeur prof2 = new Professeur ("info bidon","info bidon");
		
		profDao.modifierProfesseur(prof2);
		
		//delete student
		profDao.supprimerProfesseur(1);
		
		
	}
}