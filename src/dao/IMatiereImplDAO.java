package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Matiere;
import beans.Salle;
import beans.Typesalle;

public class IMatiereImplDAO implements IMatiereDAO {

	@Override
	public List<Matiere> listeMatiere() {
		// TODO Auto-generated method stub
ArrayList<Matiere> matieres = new ArrayList<Matiere>();
		
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from Matiere ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Matiere matiere=new Matiere();
				matiere.setId(Integer.parseInt(rs.getString("id")));
				matiere.setNom(rs.getString("nomMatiere"));
				//matiere.setModule(rs.getInt("numero"));
				matieres.add(matiere);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return matieres;
	
	}

}
