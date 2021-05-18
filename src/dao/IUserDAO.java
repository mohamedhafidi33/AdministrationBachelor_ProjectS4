package dao;

import beans.*;

public interface IUserDAO {
	void saveUser(User user);
	User updateUser(int id,User user);
	void deleteUser(int id);
}