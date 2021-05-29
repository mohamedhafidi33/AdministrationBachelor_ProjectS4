package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import beans.Absence;
import beans.Etudiant;
import beans.ME_Absence;
import beans.Matiere;
import beans.Role;
import beans.User;

public class IAbsenceImplDAO implements IAbsenceDAO {

	@Override
	public void ajouter_absence(String c, Etudiant e, Matiere m,Date date) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into absence(creneau,date,Etudiant_Id,Matiere_Id) values(?,?,?,?) ");
			ps.setString(1,c);
			ps.setDate(2, date);
			ps.setInt(3,e.getId());
			ps.setInt(4,m.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("error");
		}		

	}

	@Override
	public void supprimer_absence(ME_Absence a) {
		// TODO Auto-generated method stub

	}

}
