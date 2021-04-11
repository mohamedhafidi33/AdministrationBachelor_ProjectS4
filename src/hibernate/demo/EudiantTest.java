package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.Etudiant;
import beans.User;

public class EudiantTest {
	
	public static void main(String[] args) {
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	Session session = factory.openSession();
	
	try {
		// create a student object
					System.out.println("Creating new student object...");
					User tempuser = new User("hala", "omad");
					Etudiant etudiant=new Etudiant("mohamed","hafidi",tempuser);

		// start a transaction
					session.beginTransaction();

		// save the student object
					System.out.println("Saving the student...");
					session.save(tempuser);
					session.save(etudiant);
		// commit transaction
					session.getTransaction().commit();

					System.out.println("Done!");
				} finally {
					factory.close();
				}
}
}