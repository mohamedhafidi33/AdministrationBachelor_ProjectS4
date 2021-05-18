package testsDAOs;

import java.util.List;

import dao.ISalleImplDAO;
import util.HibernateUtil;
import beans.*;
import dao.*;

public class TestUserDAO {
	public static void main(String[] args) {
		IUserImplDAO userDao = new IUserImplDAO ();
		//add User
		//User user= new User( "userNAME","124578");
		
		//userDao.saveUser(user);
		// update User
		
		
		User user2=new User("useerrr","47584");
		userDao.updateUser(2,user2);
		
        //delete User 
		//userDao.deleteUser();
		
		
	}
}

