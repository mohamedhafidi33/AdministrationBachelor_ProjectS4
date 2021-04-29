package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Etudiant;
import beans.Gender;
import beans.Professeur;
import beans.Salle;
import beans.Typesalle;
import beans.User;

public class IProfesseurImplDAO implements IProfesseurDAO{

	@Override
	public Professeur getProf(User user) {
		// TODO Auto-generated method stub
		Professeur p=new Professeur();
		Connection conexion=DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conexion.prepareStatement(
					"select * from professeur where User_id=? ");
			ps.setInt(1, user.getId());
			
			 ResultSet rs = ps.executeQuery();
				if(rs.next()){
					p.setId(Integer.parseInt(rs.getString("id")));
					p.setCin(rs.getString("cin"));
					p.setEmail(rs.getString("email"));
					p.setNationalite(rs.getString("nationalite"));
					p.setNom(rs.getString("nom"));
					p.setPrenom(rs.getString("prenom"));
					p.setProvince(rs.getString("province"));
					//p.setSexe(Gender.valueOf(rs.getString("sexe")));
					p.setVille(rs.getString("ville"));
				}			
			ps.close();
			System.out.println("query executed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public Professeur getProfById(int id) {
		Professeur p=new Professeur();
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from professeur where id=? ;");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p.setId(Integer.parseInt(rs.getString("id")));
				p.setCin(rs.getString("cin"));
				p.setEmail(rs.getString("email"));
				p.setNationalite(rs.getString("nationalite"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setProvince(rs.getString("province"));
				//p.setSexe(Gender.valueOf(rs.getString("sexe")));
				p.setVille(rs.getString("ville"));
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return p;
	}
	
	}
