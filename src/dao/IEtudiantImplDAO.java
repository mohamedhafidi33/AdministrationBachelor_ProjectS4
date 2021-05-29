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
import beans.User;

public class IEtudiantImplDAO implements IEtudiantDAO{

	@Override
	public void ajouter_etudiant(Etudiant e, User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer_etudiant(Etudiant e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Etudiant getEtudiant(User user) {
		// TODO Auto-generated method stub
		Etudiant e=new Etudiant();
		Connection conexion=DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conexion.prepareStatement(
					"select * from etudiant where User_id=? ");
			ps.setInt(1, user.getId()+1);
			System.out.print("votre id "+user.getId());
			 ResultSet rs = ps.executeQuery();
				if(rs.next()){
					e.setId(Integer.parseInt(rs.getString("id")));
					e.setCin(rs.getString("cin"));
					e.setCne(rs.getString("cne"));
					e.setEmail(rs.getString("email"));
					e.setEtablissement(rs.getString("etablissement"));
					e.setLieuBac(rs.getString("lieuBac"));
					e.setDateInscription(rs.getDate("dateInscription"));
					e.setDateNaissance(rs.getDate("dateNaissance"));
					e.setLieuNaissance(rs.getString("lieuNaissance"));
					e.setLycee(rs.getString("lycee"));
					e.setMention(rs.getString("mention"));
					e.setNationalite(rs.getString("nationalite"));
					e.setNom(rs.getString("nom"));
					e.setPrenom(rs.getString("prenom"));
					e.setProvince(rs.getString("province"));
					e.setSexe(Gender.valueOf(rs.getString("sexe")));
					e.setVille(rs.getString("ville"));
					System.out.print("votre nom : "+e.getNom());
				}			
			ps.close();
			System.out.println("query executed");
		} catch (Exception f) {
			f.printStackTrace();
		}
		return e;
	}
	@Override
	public List<Etudiant> listEtudiantByMatiere(int idMatiere) {
		// TODO Auto-generated method stub
		
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		Connection conexion=DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conexion.prepareStatement(
					"select e.* from etudiant e,filiere f,semestre s,module m, matiere ma where e.filiere_id=f.id and s.filiere_id=f.id and m.semestre_id=s.id and ma.module_id=m.id and ma.id=? ;");
			ps.setInt(1, idMatiere);
			 ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Etudiant e=new Etudiant();
					e.setId(Integer.parseInt(rs.getString("id")));
					e.setCin(rs.getString("cin"));
					e.setCne(rs.getString("cne"));
					e.setEmail(rs.getString("email"));
					e.setEtablissement(rs.getString("etablissement"));
					e.setLieuBac(rs.getString("lieuBac"));
					e.setDateInscription(rs.getDate("dateInscription"));
					e.setDateNaissance(rs.getDate("dateNaissance"));
					e.setLieuNaissance(rs.getString("lieuNaissance"));
					e.setLycee(rs.getString("lycee"));
					e.setMention(rs.getString("mention"));
					e.setNationalite(rs.getString("nationalite"));
					e.setNom(rs.getString("nom"));
					e.setPrenom(rs.getString("prenom"));
					e.setProvince(rs.getString("province"));
					//e.setSexe(Gender.valueOf(rs.getString("sexe")));
					e.setVille(rs.getString("ville"));
					etudiants.add(e);
				}			
			ps.close();
			System.out.println("query executed");
		} catch (Exception f) {
			f.printStackTrace();
		}
		return etudiants;
	}
	
	}

