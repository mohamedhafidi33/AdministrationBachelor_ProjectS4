package dao;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEntities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl ="jdbc:mysql://localhost:3306/bd_administration?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="Mhafidi2000:";
		try {
			System.out.print("Connecting to database"+jdbcUrl);
			Connection myConn =DriverManager.getConnection(jdbcUrl,user,password);
			System.out.print("Connection succefull !!!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}