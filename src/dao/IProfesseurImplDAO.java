package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Etudiant;
import beans.Gender;
import beans.Professeur;
import beans.Role;
import beans.Salle;
import beans.Typesalle;
import beans.User;

public class IProfesseurImplDAO implements IProfesseurDAO{
	IUserDAO iuser=new UserTest();
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
	
	@Override
	public void ajouterProf(Professeur prof) {
		Connection connexion = DAOFACTORY.getConnection();
		User user=new User();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into professeur(nom,prenom,cin,email,nationalite,ville,province,sexe,User_id) values(?,?,?,?,?,?,?,?,?) ");
			user.setUsername(prof.getPrenom().substring(0,1)+prof.getNom());
			user.setPassword(prof.getCin());
			user.setRole(Role.professeur);
			iuser.ajouterUser(user);
			ps.setString(1, prof.getNom());
			ps.setString(2, prof.getPrenom());
			ps.setString(3, prof.getCin());
			ps.setString(4, prof.getEmail());
			ps.setString(5, prof.getNationalite());
			ps.setString(6, prof.getVille());
			ps.setString(7, prof.getProvince());
			ps.setString(8, prof.getSexe().toString());
			System.out.println("sexe f DAO : "+prof.getSexe());
			ps.setInt(9, iuser.getUser(user.getUsername(), user.getPassword()).getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}		
	}

	
	}
