package dao;

import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
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
//		IReservationImplDAO ires=new IReservationImplDAO();
//		UserTest u=new UserTest();
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
//		Professeur prof=new Professeur();
//		prof.setId(1);
//		ExcelGenerator t=new ExcelGenerator();
//		try {
//			t.excelData("C:/Users/hp/Documents/Book1.xlsx");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		IProfesseurImplDAO iprof=new IProfesseurImplDAO();
		//u.supprimerUser(user);
		//iprof.supprimerProf(prof);
		//System.out.println("user is not nulllllll"+iprof.listProfsBySemestre(1));
		IEtudiantImplDAO itud=new IEtudiantImplDAO();
		
//		IFiliereImplDAO f=new IFiliereImplDAO();
		IMatiereImplDAO imat=new IMatiereImplDAO();
		IAbsenceDAO iabs=new IAbsenceImplDAO();
//		System.out.println(f.getFiliereByName("BGI").getId());
//		for(int i=0;i<5;i++) {
//		System.out.println(iabs.listAbsenceByMatiere(1).get(i).getCreneau());}
		// Set up the SMTP server.
//		java.util.Properties props = new java.util.Properties();
//		props.put("mail.smtp.host", "smtp.myisp.com");
//		Session session = Session.getDefaultInstance(props, null);
//
//		// Construct the message
//		String to = "you@you.com";
//		String from = "me@me.com";
//		String subject = "Hello";
//		Message msg = new MimeMessage(session);
//		try {
//		    msg.setFrom(new InternetAddress(from));
//		    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//		    msg.setSubject(subject);
//		    msg.setText("Hi,\n\nHow are you?");
//
//		    // Send the message.
//		    Transport.send(msg);
//		} catch (MessagingException e) {
//		    // Error.
//		}
		//System.out.println(imat.getMatiereByName("Java1").getId());
		System.out.println(itud.listEtudiantByMatiere(7).get(0).getPrenom());
	}
}