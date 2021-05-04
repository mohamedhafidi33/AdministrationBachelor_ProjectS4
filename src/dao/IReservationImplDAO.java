package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Creneau;
import beans.Reservation;
import beans.Salle;
import beans.Typesalle;

public class IReservationImplDAO implements IReservationDAO{
	ISalleImplDAO isalle=new ISalleImplDAO();
	@Override
	public void ajouterReservation(Reservation reservation) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into reservation(crenau,date,Professeur_Id,Salle_Id)  values(?,?,?,?)");
			ps.setString(1, reservation.getCrenau().toString());
			ps.setDate(2, (Date) reservation.getDate());
			ps.setInt(3, reservation.getProfesseur().getId());
			ps.setInt(4, reservation.getSalle().getId());
			ps.executeUpdate();
			ps.close();
			reservation.getSalle().setOccupation(true);
			isalle.modifierSalle(reservation.getSalle());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}		
	}

	@Override
	public void supprimerReservation(Reservation reservation) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("delete from reservation where id=? ; ");
			ps.setInt(1, reservation.getId()+1);
			ps.executeUpdate();
	        ps.close();
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
		
	}

	@Override
	public void supprimerParSalle(Salle salle) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("delete from reservation where Salle_Id=? ; ");
			ps.setInt(1, salle.getId());
			ps.executeUpdate();
	        ps.close();
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
		
	}
	
	@Override
	public List<Reservation> listreseRvations() {
		List<Reservation> reservations = new ArrayList<Reservation>();
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from reservation ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reservation reservation=new Reservation();
				reservation.setCrenau(Creneau.valueOf(rs.getString("crenau")));
				reservation.setDate(rs.getDate("date"));
				//reservation.setProfesseur(rs.getInt("Professeur_id"));
				reservation.setSalle(isalle.getSalleById(rs.getInt("Salle_id")));
				reservations.add(reservation);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return reservations;
	}
}
