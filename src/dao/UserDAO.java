package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import beans.User;

public class UserDAO {
	
	public User getUser(String username, String password) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from User where username=:username and password=:password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			System.out.print("dazt");
			List<User> users = query.list();
			session.getTransaction().commit();
			session.close();
			System.out.print(users.size());
			return users.get(0);
		} finally {
			factory.close();
		}
	}


	public boolean login(String username, String password) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from User where username=:username");
			query.setParameter("username", username);
			List<User> users = query.list();
			User user = users.get(0);
			session.getTransaction().commit();
			session.close();
			System.out.print(user.getPassword());
			System.out.print("dazt2");
			if (user.getPassword().equals(password)) {
				return true;
			}
			// System.out.print(users.size());
			// return users.get(0);
		} finally {
			factory.close();
		}
		return false;
	}

	public void getTest() {
		System.out.println("testMethod");
	}

}