package dao;

import beans.User;

public interface IUserDAO {

	User getUser(String username, String password);

	boolean login(String username, String password);

	void getTest();

}
