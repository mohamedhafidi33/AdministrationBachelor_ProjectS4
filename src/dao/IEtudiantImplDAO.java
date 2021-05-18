package dao;

import java.util.ArrayList;



import java.util.List;



import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.*;
import java.util.*;

import beans.*;

public class IEtudiantImplDAO implements IEtudiantDAO{
	Connection conn=SingletonConnection.getConnection();
	
	 //ok
		// TODO Auto-generated method stub
		 
			User user=new User();
			IUserImplDAO userDao=new IUserImplDAO();
			
			
		
public void saveEtudiant(Etudiant etudiant) {
		try {
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO etudiant (nom,prenom,cin,cne,email,sexe,etablissement,lieuNaissance,lieuBac,dateNaissance,dateInscription,lycee,mention,province,ville,nationalite) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			ps.setString(1, etudiant.getNom());
			System.out.println("this is the name"+ etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getCin());
			ps.setString(4, etudiant.getCne());
			ps.setString(5, etudiant.getEmail());
			ps.setString(6, etudiant.getSexe().toString());
			System.out.println("HADA HWA GENDER : "+etudiant.getSexe());
			ps.setString(7, etudiant.getEtablissement());
			ps.setString(8, etudiant.getLieuNaissance());
			ps.setString(9, etudiant.getLieuBac());
			ps.setDate(10, new java.sql.Date((etudiant.getDateNaissance()).getTime()));
			ps.setDate(11, new java.sql.Date((etudiant.getDateInscription()).getTime()));
			ps.setString(12, etudiant.getLycee());
			ps.setString(13, etudiant.getMention());
			ps.setString(14, etudiant.getProvince());
			ps.setString(15, etudiant.getVille());
			ps.setString(16, etudiant.getNationalite());
		
			
			
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
			user.setUsername(etudiant.getNom().substring(0,1)+etudiant.getPrenom());
			user.setRole(Role.etudiant);
			user.setPassword(etudiant.getCne());
			userDao.saveUser(user);
			System.out.println("user saved !!!!");
			
		}
		catch (SQLException e) {
			 e.printStackTrace();
			 
		}
	}

public List<Etudiant> listEtudiants() { 
	// TODO Auto-generated method stub
	
	List<Etudiant> etudiants =new ArrayList<Etudiant>();
	try {
		PreparedStatement ps= conn.prepareStatement("select * from etudiant");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Etudiant etudiant1 = new Etudiant();
			etudiant1.setId(Integer.parseInt(rs.getString("id")));
			etudiant1.setNom(rs.getString("nom"));
			etudiant1.setPrenom(rs.getString("prenom"));
			//ila l9iti kifach t5dem dyal gender 3afak !!
			etudiant1.setCin(rs.getString("cin"));
			etudiant1.setCne(rs.getString("cne"));
			//etudiant1.setDateInscription(new java.sql.Date((etudiant1.getDateInscription()).getTime()));
			//etudiant1.setDateNaissance(new java.sql.Date((etudiant1.getDateNaissance()).getTime()));
			etudiant1.setEmail(rs.getString("email"));
			etudiant1.setEtablissement(rs.getString("etablissement"));
		    etudiant1.setLieuNaissance(rs.getString("lieuNaissance"));
			etudiant1.setLycee(rs.getString("lycee"));
			etudiant1.setMention(rs.getString("mention"));
			etudiant1.setProvince(rs.getString("province"));
			etudiant1.setVille(rs.getString("ville"));
			etudiant1.setNationalite(rs.getString("nationalite"));
			etudiants.add(etudiant1);	
			
			System.out.println("mchat");
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	
	return etudiants;
}

	
	public Etudiant getEtudiant(int id) {  
		// TODO Auto-generated method stub
		Etudiant etudiant1=new Etudiant();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from etudiant where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				etudiant1.setId(rs.getInt("id"));
				etudiant1.setNom(rs.getString("nom"));
				etudiant1.setPrenom(rs.getString("prenom"));
				etudiant1.setCin(rs.getString("cin"));
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return etudiant1;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) { 
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE etudiant SET id = ? ,nom= ? ,prenom=? ,cin=?,cne=?,email=?,etablissement= ?,lieuNaissance = ?,lycee=?,mention=?,province= ?,ville=?, nationalite=? WHERE id=?");
			
			ps.setInt(1, etudiant.getId());
			ps.setString(2, etudiant.getNom());
			System.out.println("this is the name"+ etudiant.getNom());
			ps.setString(3, etudiant.getPrenom());
			ps.setString(4, etudiant.getCin());
			ps.setString(5, etudiant.getCne());
			ps.setString(6, etudiant.getEmail());
			ps.setString(7, etudiant.getEtablissement());
			ps.setString(8, etudiant.getLieuNaissance());
			ps.setString(9, etudiant.getLycee());
			ps.setString(10, etudiant.getMention());
			ps.setString(11, etudiant.getProvince());
			ps.setString(12, etudiant.getVille());
			ps.setString(13, etudiant.getNationalite());
			ps.setInt(14, etudiant.getId());
			ps.executeUpdate();
			ps.close();
			System.out.println("modification validée mn DAO !");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return etudiant;
	}

	@Override
	public void deleteEtudiant(int id) { 
		
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM etudiant WHERE id = ?;");
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
	
}