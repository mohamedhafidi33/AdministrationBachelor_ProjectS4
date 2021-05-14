package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Professeur;
import beans.Role;
import beans.User;

public class UserTest implements IUserDAO{
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
					p.setId(Integer.parseInt(rs.getString("id")));
					p.setUsername(rs.getString("username"));
					p.setPassword(rs.getString("password"));
					p.setRole(Role.valueOf(rs.getString("role")));
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
	@Override
	public void ajouterUser(User user) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					" insert into user(username,password,role)  values(?,?,?) ");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole().toString());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}		
		
	}
	@Override
	public void supprimerUser(User user) {
		System.out.println("hahowa id waaasl" +user.getId());
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("delete from user where id=? ; ");
			ps.setInt(1, user.getId());
			ps.executeUpdate();
	        ps.close();
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
	}
	
	@Override
	public User getUserById(int id) {
		User user=new User();
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("select * from user where id=? ;");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setId(Integer.parseInt(rs.getString("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(Role.valueOf(rs.getString("role")));
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return user;
	}
	}