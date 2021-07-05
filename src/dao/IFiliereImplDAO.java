package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Filiere;
import beans.Semestre;

public class IFiliereImplDAO implements IFiliereDAO {
Connection connexion = DAOFACTORY.getConnection();
Filiere filiere = new Filiere();
public int selectByNomFil(String nomFiliere) {
	try {
		PreparedStatement ps = connexion.prepareStatement("select * from filiere where nomFiliere = ?");
		ps.setString(1, nomFiliere);
		ResultSet rs = ps.executeQuery();
		
		if  (rs.next()) {
			
			filiere.setId(rs.getInt("id"));
			
			/*................*/
			System.out.println("valide");
		}
	}
	catch (SQLException e) {
		 e.printStackTrace();
	}
	
	return filiere.getId();
}
	@Override
	public Filiere getFiliereByName(String name) {
		Filiere f=new Filiere();
		
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from filiere where nomFiliere=? ;");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				f.setId(rs.getInt("id"));
				f.setNom(rs.getString("nomFiliere"));
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return f;
	}
	
	public void saveFiliere(String nomFiliere) {
		try {
			
			PreparedStatement ps= connexion.prepareStatement("INSERT INTO filiere (nomFiliere) VALUES(?)");
			
			ps.setString(1, nomFiliere);
			System.out.println("this is the name"+ nomFiliere);
			
			ps.executeUpdate();
			ps.close();
	}
		
		catch (SQLException e) {
			 e.printStackTrace();
			 
		}

	}
	@Override
	public List<Filiere> listeFiliere() {
		// TODO Auto-generated method stub
ArrayList<Filiere> filieres = new ArrayList<Filiere>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from Filiere ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Filiere filiere=new Filiere();
				filiere.setId(Integer.parseInt(rs.getString("id")));
				filiere.setNom(rs.getString("nomFiliere"));
				//matiere.setModule(rs.getInt("numero"));
				filieres.add(filiere);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return filieres;
	
	}
}
