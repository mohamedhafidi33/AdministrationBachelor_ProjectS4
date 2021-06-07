package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.*;

public class IDocumentImplDAO implements IDocumentDAO{
	
	Connection conn=SingletonConnection.getConnection();
	
	public int uploadDocument(InputStream file) {
		
		int row=0;
		
		Etudiant etudiant = new Etudiant();
		Document doc = new Document();
	try {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps= conn.prepareStatement("INSERT INTO document (file) VALUES (?)");
		
		//ps.setString(1, doc.getType().toString());
		
		if(file != null) {
			ps.setBlob(1, file);
		}
		
		row = ps.executeUpdate();
		ps.close();
	}
	catch (SQLException e) {
		 e.printStackTrace();
		 
	}
	return row;
  }
}


