package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Matiere;
import beans.Semestre;

public class ISemestreImplDAO implements ISemestreDAO {
		Connection conn=DAOFACTORY.getConnection();
		@Override
		public List<Semestre> listeSemestre() {
			// TODO Auto-generated method stub
	ArrayList<Semestre> semestres = new ArrayList<Semestre>();
			
			Connection connexion = DAOFACTORY.getConnection();
			try {
				PreparedStatement ps=connexion.prepareStatement("select * from Semestre ;");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Semestre semestre=new Semestre();
					semestre.setId(Integer.parseInt(rs.getString("id")));
					semestre.setNom(rs.getString("nomSemestre"));
					//matiere.setModule(rs.getInt("numero"));
					semestres.add(semestre);
				}
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return semestres;
		
		}
		@Override
		public int getIdSemestre(String nomSemestre){
			int idsemestre=0;
			Connection connexion = DAOFACTORY.getConnection();
			try {
				PreparedStatement ps=connexion.prepareStatement("select * from semestre where nomSemestre=? ;");
				ps.setString(1, nomSemestre);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					idsemestre=Integer.parseInt(rs.getString("id"));
				}
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return idsemestre;
		}
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
	