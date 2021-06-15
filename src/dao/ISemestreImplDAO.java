package dao;
import beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ISemestreImplDAO {
	Connection conn=SingletonConnection.getConnection();
	public void saveSemestre(String nomSemestre, int filiere_id) {
try {
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO semestre (nomSemestre, filiere_id) VALUES(?,?)");
			
			ps.setString(1, nomSemestre);
			ps.setInt(2,filiere_id);
			
			ps.executeUpdate();
			ps.close();
	}
		
		catch (SQLException e) {
			 e.printStackTrace();
			 
		}
	}
	
	public int searchByNom(String nomSemestre) {
		Semestre semestre=  new Semestre();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from semestre where nomSemestre = ?");
			ps.setString(1,nomSemestre);
			ResultSet rs = ps.executeQuery();
			
			if  (rs.next()) {
				
				semestre.setId(rs.getInt("id"));
				
				/*................*/
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return semestre.getId();
	}
	
	public String findName(int id) {
		Semestre semestre=  new Semestre();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from semestre where id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			if  (rs.next()) {
				
				semestre.setNom(rs.getString("nomSemestre"));
				
				/*................*/
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return semestre.getNom();
			
		}
	}



