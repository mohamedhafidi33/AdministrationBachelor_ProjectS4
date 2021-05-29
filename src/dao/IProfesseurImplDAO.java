package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
					p.setSexe(Gender.valueOf(rs.getString("sexe")));
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
	public void supprimerProf(Professeur prof) {
		Professeur pro=getProfById(prof.getId());
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("delete from professeur where id=? ; ");
			ps.setInt(1, prof.getId());
			ps.executeUpdate();
	        ps.close();
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
		//System.out.println(prof.getId());
		
		iuser.supprimerUser(pro.getUser());
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
				p.setSexe(Gender.valueOf(rs.getString("sexe")));
				p.setVille(rs.getString("ville"));	
				p.setUser(iuser.getUserById(Integer.parseInt(rs.getString("User_id"))));
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
		 System.out.println("Heere's the name mn dao"+prof.getPrenom());
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into professeur(nom,prenom,cin,email,nationalite,ville,province,sexe,User_id) values(?,?,?,?,?,?,?,?,?) ");
			user.setUsername(prof.getPrenom().substring(1,2)+prof.getNom());
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
	
	@Override
	public List<Professeur> listProfs() {
		ArrayList<Professeur> profs = new ArrayList<Professeur>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from professeur ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Professeur prof=new Professeur();
				prof.setId(Integer.parseInt(rs.getString("id")));
				prof.setNom(rs.getString("nom"));
				prof.setPrenom(rs.getString("prenom"));
				prof.setCin(rs.getString("cin"));
				prof.setNationalite(rs.getString("nationalite"));
				prof.setVille(rs.getString("ville"));
				prof.setProvince(rs.getString("province"));
				prof.setEmail(rs.getString("email"));
				//prof.setSexe(Gender.valueOf(rs.getString("sexe")));
				profs.add(prof);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return profs;
	}
	@Override
	public void modifierProf(Professeur prof) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement("update professeur set id=? , nom=? , prenom=? , cin=?  , email=? , nationalite=? , ville=? , province=? , sexe=? where id=? ;");
			
			ps.setInt(1,prof.getId());
			ps.setString(2, prof.getNom());
			ps.setString(3, prof.getPrenom());
			ps.setString(4, prof.getCin());
			ps.setString(5, prof.getEmail());
			ps.setString(6, prof.getNationalite());
			ps.setString(7, prof.getVille());
			ps.setString(8, prof.getProvince());
			ps.setString(9, prof.getSexe().toString());
			ps.setInt(10, prof.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	@Override
	public void addEnseignement(int idProf,int idMatiere) {
		Connection connexion = DAOFACTORY.getConnection();
		User user=new User();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into enseignements(Professeur_id,Matiere_id) values(?,?) ");
			ps.setInt(1, idProf);
			ps.setInt(2, idMatiere);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}		
	}
	@Override
	public int getIdProf(String nom,String prenom){
		int idprof=0;
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from professeur where nom=? and prenom=? ;");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				idprof=Integer.parseInt(rs.getString("id"));
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return idprof;
	}
	@Override
	public void deleteEnseignement(int profId) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("delete from enseignements where Professeur_id=? ; ");
			ps.setInt(1, profId);
			ps.executeUpdate();
	        ps.close();
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
	}
	@Override
	public int countProfs() {
		int cmpt=0;
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT COUNT(*) FROM professeur ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cmpt=rs.getInt("COUNT(*)");
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return cmpt;
	}
	@Override
	public List<Professeur> listProfsBySemestre(int semestre_Id) {
		ArrayList<Professeur> profs = new ArrayList<Professeur>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from professeur p , enseignements e , matiere ma , module mo , semestre s where p.id=e.Professeur_id and e.Matiere_id=ma.id and ma.module_id=mo.id and mo.semestre_id=s.id and s.id=? ;");
			ps.setInt(1, semestre_Id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Professeur prof=new Professeur();
				prof.setId(Integer.parseInt(rs.getString("id")));
				prof.setNom(rs.getString("nom"));
				prof.setPrenom(rs.getString("prenom"));
				prof.setCin(rs.getString("cin"));
				prof.setNationalite(rs.getString("nationalite"));
				prof.setVille(rs.getString("ville"));
				prof.setProvince(rs.getString("province"));
				prof.setEmail(rs.getString("email"));
				prof.setSexe(Gender.valueOf(rs.getString("sexe")));
				profs.add(prof);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return profs;
	}
}
	
