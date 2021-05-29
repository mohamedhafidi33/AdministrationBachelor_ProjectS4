package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Filiere;

public class IFiliereImplDAO implements IFiliereDAO {

	@Override
	public Filiere getFiliereByName(String name) {
		Filiere f=new Filiere();
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from filiere where nomFiliere=? ;");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				f.setId(rs.getInt("id"));
				f.setNom(rs.getString("nomFiliere"));
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return f;
	}

}
