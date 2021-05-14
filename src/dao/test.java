package dao;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import dao.IProfesseurImplDAO;
import beans.Professeur;
import beans.Salle;
import beans.Typesalle;
import beans.User;

public class test {

	public static void main(String[] args) {
		IReservationImplDAO ires=new IReservationImplDAO();
		UserTest u=new UserTest();
		// TODO Auto-generated method stub
		//IUserImplDAO i = new IUserImplDAO();
		//UserTest t=new UserTest();
		//System.out.print(t.login("hello", "world"));
		//User user=new User();
		//user.setId(26);
		//System.out.print(u.getRole());
		//Connection conn=DAOFACTORY.getConnection();
		//IEtudiantImplDAO dao=new IEtudiantImplDAO();
		//dao.getEtudiant(u);
//		ISalleImplDAO s = new ISalleImplDAO();
//		Salle salle=new Salle();
//		salle.setDescription("blackboard+epson datashow");
//		salle.setId(12);
//		salle.setNumero(12);
//		salle.setTypesalle(Typesalle.Cours);
//		s.modifierSalle(salle);
		//for(int i=0;i<20;i++) {
		//System.out.println(s.disponibleSalles().get(i).getDescription());}
//		System.out.print(s.listSallebyDate( Date.valueOf("2021-05-20")).get(0).getId());
		Professeur prof=new Professeur();
		prof.setId(1);
		//IProfesseurImplDAO iprof=new IProfesseurImplDAO();
		//u.supprimerUser(user);
		//iprof.supprimerProf(prof);
		System.out.println("user is not nulllllll"+ires.ReservationByProf(prof).get(0).getId());
	}
}