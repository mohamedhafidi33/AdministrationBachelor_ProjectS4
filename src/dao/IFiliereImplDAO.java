package dao;


import beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IFiliereImplDAO implements IFiliereDAO{
	Connection conn=SingletonConnection.getConnection();
	Filiere filiere = new Filiere();
	
	public int selectByNomFil(String nomFiliere) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from filiere where nomFiliere = ?");
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
	
	public void saveFiliere(String nomFiliere) {
		try {
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO filiere (nomFiliere) VALUES(?)");
			
			ps.setString(1, nomFiliere);
			System.out.println("this is the name"+ nomFiliere);
			
			ps.executeUpdate();
			ps.close();
	}
		
		catch (SQLException e) {
			 e.printStackTrace();
			 
		}

	}
}
