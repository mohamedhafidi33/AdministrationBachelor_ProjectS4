package hibernate.demo;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import beans.Role;
import beans.User;

public class Usertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		System.out.print("hello");
		Session session = factory.openSession();
		
		try {
// create a student object
			System.out.println("Creating new user...");
			User tempuser = new User("Asmae ", "mahjoubiAA ",Role.student);
			

// start a transaction
			session.beginTransaction();

// save the student object
			System.out.println("Saving the user...");
			session.save(tempuser);

// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
