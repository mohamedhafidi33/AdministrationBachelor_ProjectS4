package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Absence;
import beans.Creneau;
import beans.Etudiant;
import beans.ME_Absence;
import beans.Matiere;
import beans.Absence;
import beans.Role;
import beans.User;

public class IAbsenceImplDAO implements IAbsenceDAO {

	@Override
	public void ajouter_absence (String c, Etudiant e, Matiere m,Date date) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into absence(creneau,date,Etudiant_Id,Matiere_Id) values(?,?,?,?) ");
			ps.setString(1,c);
			ps.setDate(2, date);
			ps.setInt(3,e.getId());
			ps.setInt(4,m.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("error");
		}		

	}

	@Override
	public void supprimer_absence(Absence a) {
		// TODO Auto-generated method stub
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("delete from absence where id=? ; ");
			ps.setInt(1, a.getId());
			ps.executeUpdate();
	        ps.close();
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
	}

	@Override
	public List<Absence> listAbsenceByMatiere(int idmat) {
ArrayList<Absence> absences = new ArrayList<Absence>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from absence where Matiere_Id=?;");
			ps.setInt(1, idmat);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Absence absence=new Absence();
				absence.setId(Integer.parseInt(rs.getString("id")));
				absence.setCreneau(Creneau.valueOf(rs.getString("creneau")));
				absence.setDate(Date.valueOf(rs.getString("date")));
				absence.setEtudiant_Id(rs.getInt("Etudiant_Id"));
				System.out.println("hahowa id d etudiant west dao"+rs.getInt("Etudiant_Id"));
				absence.setMatiere_Id(rs.getInt("Matiere_Id"));
				absences.add(absence);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return absences;
	}
	public List<Etudiant> listEtudiantAbsenceByMatiere(int idmat){
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		Connection conexion=DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conexion.prepareStatement(
					"select e.* from etudiant e,absence a,matiere m where e.id=a.Etudiant_Id and m.id=a.Matiere_Id and m.id=? ;");
			ps.setInt(1, idmat);
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

	@Override
	public void modifierAbsence(int absence_Id, InputStream file) {
		// TODO Auto-generated method stub
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement("update absence set justificatif=? where id=? ;");
			ps.setBlob(1,file);
			ps.setInt(2, absence_Id);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}
	
	@Override
	public List<Absence> listAbsenceByEtudiant(int idetu,int idmat) {
		ArrayList<Absence> absences = new ArrayList<Absence>();
				
				Connection connexion = DAOFACTORY.getConnection();
				try {
					PreparedStatement ps=connexion.prepareStatement("select a.* from absence a,etudiant e where a.Etudiant_Id=e.id and e.id=? and a.Matiere_Id=? ;");
					ps.setInt(1, idetu);
					ps.setInt(2, idmat);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Absence absence=new Absence();
						absence.setId(Integer.parseInt(rs.getString("id")));
						absence.setCreneau(Creneau.valueOf(rs.getString("creneau")));
						absence.setDate(Date.valueOf(rs.getString("date")));
						absence.setEtudiant_Id(rs.getInt("Etudiant_Id"));
						System.out.println("hahowa id d etudiant west dao"+rs.getInt("Etudiant_Id"));
						absence.setMatiere_Id(rs.getInt("Matiere_Id"));
						absences.add(absence);
					}
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("error");
				}
				return absences;
			}
	
}
