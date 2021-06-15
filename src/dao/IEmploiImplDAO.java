package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.*;

public class IEmploiImplDAO {
	Connection conn=SingletonConnection.getConnection();
	Schedule emploi = new Schedule();
	public void addIdsSchedule( String nomEmploi,Session session, int id_annee, int id_semestre, InputStream emploiFile) {
		
		
	   try {
				
				PreparedStatement ps= conn.prepareStatement("INSERT INTO schedule (nomEmploi,session, AnneeUniversitaire_id,Semester_id,emploiFile) VALUES(?,?,?,?,?)");
				
				ps.setString(1,nomEmploi);
			    ps.setString(2, session.toString());
				ps.setInt(3,id_annee);
				ps.setInt(4,id_semestre);
				ps.setBlob(5, emploiFile);
				
				
				ps.executeUpdate();
				ps.close();
		}
			
			catch (SQLException e) {
				 e.printStackTrace();
				 
			}
		}
	
	public List<Schedule> listEmplois() { 
		// TODO Auto-generated method stub
		
		List<Schedule> emplois =new ArrayList<Schedule>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from schedule");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Schedule emploi = new Schedule();
				emploi.setId(Integer.parseInt(rs.getString("id")));
				emploi.setSession(Session.valueOf(rs.getString("session")));
				emploi.setNomEmploi(rs.getString("nomEmploi"));
				
				emplois.add(emploi);	
				
				System.out.println("emploi ajouté");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return emplois;
	}
	
	public int selectByNom(String nomEmploi) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from filiere where nomEmploi = ?");
			ps.setString(1, nomEmploi);
			ResultSet rs = ps.executeQuery();
			
			if  (rs.next()) {
				
				emploi.setId(rs.getInt("id"));
				
				/*................*/
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return emploi.getId();
	}
	public Schedule selectById(int id) { 
			
			try {
				PreparedStatement ps= conn.prepareStatement("select * from schedule where id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if  (rs.next()) {
					
					emploi.setId(rs.getInt("id"));
					emploi.setNomEmploi(rs.getString("nomEmploi"));
					emploi.setSession(Session.valueOf(rs.getString("session")));
					emploi.setEmploiFile(rs.getBlob("emploiFile").getBinaryStream());
					
				}
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
			return emploi;
		}
	
	public void deleteById( int id) {
		
			try {
				PreparedStatement ps= conn.prepareStatement("DELETE FROM schedule WHERE id = ?;");
				ps.setInt(1, id);
				ps.executeUpdate();
				ps.close();
				System.out.println("valide mn DAO a ASMAEEE");
			}
			catch (SQLException e) {
				 e.printStackTrace();
				 System.out.println("ewa hady erreur 5/5 ");
			}
		}
	public void updateEmploi(Schedule emploi,int annee_id, int semestre_id) {
		
		try {
		PreparedStatement ps= conn.prepareStatement("UPDATE schedule set id=?,session= ?, AnneeUniversitaire_id=? , Semester_id, nomEmploi=?,emploiFile=? WHERE id=? ");
		
		ps.setInt(1, emploi.getId());
		ps.setString(2, emploi.getSession().toString());
		ps.setInt(3, annee_id);
		ps.setInt(4, semestre_id);
		ps.setString(5, emploi.getNomEmploi());
		ps.setBlob(5, emploi.getEmploiFile());
		
		ps.executeUpdate();
		ps.close();
		
	}catch (SQLException e) {
		 e.printStackTrace();
		 
	}
	}
	
	public Schedule updateEmploi(Schedule emploi) {
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE schedule SET id= ?, nomEmploi = ? ,emploiFile= ? ,session=?  WHERE id=?");
			
			ps.setInt(1, emploi.getId());
			ps.setString(2, emploi.getNomEmploi());
			System.out.println("this is the name"+ emploi.getNomEmploi());
			ps.setBlob(3, emploi.getEmploiFile());
			ps.setString(4, emploi.getSession().toString());
			ps.setInt(5, emploi.getId());
			
			ps.executeUpdate();
			ps.close();
	}
	
	catch (SQLException e) {
		 e.printStackTrace();
	}
	return emploi;
}
	
}