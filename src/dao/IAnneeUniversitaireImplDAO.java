package dao;

import beans.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import beans.Etudiant;

public class IAnneeUniversitaireImplDAO implements IAnneeUniversitaireDAO{
	Connection conn=SingletonConnection.getConnection();
	AnneeUniversitaire anneeuniv = new AnneeUniversitaire();
	
	public int selectByDateDebut(Date dateDebut, Date dateFin) {  
		// TODO Auto-generated method stub
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from anneeuniversitaire where date_debut = ? and date_fin =?");
			ps.setDate(1, dateDebut);
			ps.setDate(2, dateFin);
			ResultSet rs = ps.executeQuery();
			
			if  (rs.next()) {
				
				anneeuniv.setId(rs.getInt("id"));
				
				/*................*/
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return anneeuniv.getId();
	}
	
	public List<AnneeUniversitaire> listAnnees() { 
		// TODO Auto-generated method stub
		
		List<AnneeUniversitaire> annees =new ArrayList<AnneeUniversitaire>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from anneeuniversitaire");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				anneeuniv.setDate_debut(Date.valueOf(rs.getString("date_debut")));
				anneeuniv.setDate_fin(Date.valueOf(rs.getString("date_fin")));
				
				
				annees.add(anneeuniv);	
				
				System.out.println("mchat");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return annees;
	}


}
