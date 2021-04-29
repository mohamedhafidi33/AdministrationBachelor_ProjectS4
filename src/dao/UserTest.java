package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Role;
import beans.User;

public class UserTest {
	public User getUser(String username, String password) {
		Connection conexion=DAOFACTORY.getConnection();
		User p=new User();
		try {
			PreparedStatement ps = conexion.prepareStatement(
					"select * from user where username=? and password=? ");
			ps.setString(1, username);
			ps.setString(2, password);
			 ResultSet rs = ps.executeQuery();
				if(rs.next()){
					p.setUsername(rs.getString("username"));
					p.setPassword(rs.getString("password"));
					p.setRole(Role.valueOf(rs.getString("role")));
					System.out.print(p.getRole());
				}			
			ps.close();
			System.out.println("query executed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public boolean login(String username,String password) {
		boolean b=false;
		Connection conexion=DAOFACTORY.getConnection();
		User p=new User();
		try {
			PreparedStatement ps  = conexion.prepareStatement("SELECT * FROM User WHERE username=? ");
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("password")).equals(password) ){
				b=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	}