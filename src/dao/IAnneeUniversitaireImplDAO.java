package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AnneeUniversitaire;

public class IAnneeUniversitaireImplDAO implements IAnneeUniversitaireDAO {
	Connection conn=DAOFACTORY.getConnection();
	
	
	public int selectByDateDebut(Date dateDebut, Date dateFin) {  
		// TODO Auto-generated method stub
		AnneeUniversitaire anneeuniv = new AnneeUniversitaire();
		
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
			while(rs.next()) {
				AnneeUniversitaire anneeuniv = new AnneeUniversitaire();
				anneeuniv.setDate_debut(Date.valueOf(rs.getString("date_debut")));
				anneeuniv.setDate_fin(Date.valueOf(rs.getString("date_fin")));
				
				
				annees.add(anneeuniv);	
				
				//System.out.println("mchat");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return annees;
	}
}
