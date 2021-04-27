package dao;

import java.sql.Connection;

import beans.Salle;
import beans.Typesalle;
import beans.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IUserImplDAO i = new IUserImplDAO();
		//UserTest t=new UserTest();
		//System.out.print(t.login("hello", "world"));
		//User u=t.getUser("hello", "world");
		//System.out.print(u.getRole());
		//Connection conn=DAOFACTORY.getConnection();
		//IEtudiantImplDAO dao=new IEtudiantImplDAO();
		//dao.getEtudiant(u);
		ISalleImplDAO s = new ISalleImplDAO();
		//Salle l=new Salle(33,true,"very large salle",Typesalle.Cours);
		//s.ajouterSalle(l);
		//s.supprimerSalle(l);
		
		System.out.println(s.listsalles().get(0).getNumero());
		System.out.println(s.listsalles().get(1).getNumero());
		System.out.println(s.listsalles().get(2).getNumero());
		//System.out.println(s.listsalles().get(0).getTypesalle());
	}
}