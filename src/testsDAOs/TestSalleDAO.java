package testsDAOs;

import java.util.List;

import dao.ISalleImplDAO;
import util.HibernateUtil;
import beans.Salle;
import beans.Typesalle;

public class TestSalleDAO {
	public static void main(String[] args) {
		ISalleImplDAO salleDao = new ISalleImplDAO ();
		
		// add Salle
		Salle salle= new Salle( 1,false, "salle de TP");
		salleDao.saveSalle(salle);
	
		
		// update Salle
		
		Salle salle2=new Salle(3,true,"salle de rien du tt ");
		salleDao.updateSalle(salle2);
		
		//delete Salle
		
		salleDao.deleteSalle(2);
	}
}


