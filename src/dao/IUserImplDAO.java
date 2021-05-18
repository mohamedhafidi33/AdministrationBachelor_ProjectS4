package dao;

import java.util.ArrayList;



import java.util.List;

import org.antlr.v4.runtime.ParserInterpreter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.*;

public class IUserImplDAO implements IUserDAO{
	Connection conn=SingletonConnection.getConnection();
	@Override
	
	public void saveUser(User user) { //ok
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO users(username,password,role) VALUES(?,?,?)");
			ps.setString(1, user.getUsername());
			
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole().toString());
			ps.executeUpdate();
			ps.close();
			System.out.println("hahyya machaat ");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}



	@Override
	public User updateUser(int id,User user) { //ok
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE users SET username=?,password=? WHERE id=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3,user.getId());
            ps.executeUpdate();
			ps.close();
			System.out.println("dayza");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return user;
	}

	@Override
	public void deleteUser(int id) { //ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM users WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("ta hya dazt");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
}