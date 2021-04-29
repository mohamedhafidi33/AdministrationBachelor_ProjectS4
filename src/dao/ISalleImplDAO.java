package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Salle;
import beans.Typesalle;

public class ISalleImplDAO implements ISalleDAO{

	@Override
	public void ajouterSalle(Salle salle) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into salles(description,numero,occupation,typesalle)  values(?,?,?,?)");
			ps.setString(1, salle.getDescription());
			ps.setInt(2, salle.getNumero());
			ps.setBoolean(3, salle.isOccupation());
			ps.setString(4, salle.getTypesalle().toString());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}		
	}

	@Override
	public void supprimerSalle(Salle salle) {
		
			Connection connexion = DAOFACTORY.getConnection();
			try {
				PreparedStatement ps=connexion.prepareStatement("delete from salles where id=? ; ");
				ps.setInt(1, salle.getId()+1);
				ps.executeUpdate();
		        ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		}

	@Override
	public List<Salle> listsalles() {
		ArrayList<Salle> salles = new ArrayList<Salle>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from salles ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Salle salle=new Salle();
				salle.setId(Integer.parseInt(rs.getString("id")));
				salle.setDescription(rs.getString("description"));
				salle.setNumero(rs.getInt("numero"));
				salle.setOccupation(rs.getBoolean("occupation"));
				salle.setTypesalle(Typesalle.valueOf(rs.getString("typesalle")));
				salles.add(salle);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return salles;
	}

	@Override
	public Salle getSalleById(int id) {
		Salle salle=new Salle();
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from salles where id=? ;");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				salle.setId(Integer.parseInt(rs.getString("id")));
				salle.setDescription(rs.getString("description"));
				salle.setNumero(rs.getInt("numero"));
				salle.setOccupation(rs.getBoolean("occupation"));
				salle.setTypesalle(Typesalle.valueOf(rs.getString("typesalle")));
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return salle;
	}

	@Override
	public List<Salle> disponibleSalles() {
		ArrayList<Salle> salles = new ArrayList<Salle>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from salles ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Salle salle=new Salle();
				salle.setId(Integer.parseInt(rs.getString("id")));
				salle.setDescription(rs.getString("description"));
				salle.setNumero(rs.getInt("numero"));
				salle.setOccupation(rs.getBoolean("occupation"));
				salle.setTypesalle(Typesalle.valueOf(rs.getString("typesalle")));
				if(salle.isOccupation()==false) {
				salles.add(salle);}
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return salles;
	}
	@Override
	public void modifierSalle(Salle salle) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement("update salles set id=? , description=? , numero=? , occupation=?  , typesalle=? where id=? ;");

			ps.setInt(1, salle.getId());
			ps.setString(2, salle.getDescription());
			ps.setInt(3, salle.getNumero());
			ps.setBoolean(4, salle.isOccupation());
			ps.setString(5, salle.getTypesalle().toString());
			ps.setInt(6, salle.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
}
