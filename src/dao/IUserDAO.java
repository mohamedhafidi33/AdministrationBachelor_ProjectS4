package dao;

import beans.*;

public interface IUserDAO {
	public User getUser(String username,String password);
	public boolean login(String username,String password);
	public void getTest() ;
}
