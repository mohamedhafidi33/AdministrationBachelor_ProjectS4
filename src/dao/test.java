package dao;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import beans.Salle;
import beans.Typesalle;
import beans.User;

public class test {

	public static void main(String[] args) {
		IReservationImplDAO ires=new IReservationImplDAO();
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
		for(int i=0;i<20;i++) {
		System.out.println(s.disponibleSalles().get(i).getDescription());}
		//System.out.print(ires.listSallebyDate( Date.valueOf("2021-05-06")).get(0).getCrenau());
	}
}