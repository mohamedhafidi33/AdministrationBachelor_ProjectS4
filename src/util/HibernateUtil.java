package util;

import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import beans.*;
import beans.Module;
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.ml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/administration?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "@MYsql2020");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.FORMAT_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Absence.class);
				configuration.addAnnotatedClass(AnneeUniversitaire.class);
				configuration.addAnnotatedClass(Creneau.class);
				configuration.addAnnotatedClass(Doctype.class);
				configuration.addAnnotatedClass(Document.class);
				configuration.addAnnotatedClass(Etudiant.class);
				configuration.addAnnotatedClass(Filiere.class);
				configuration.addAnnotatedClass(Gender.class);
				configuration.addAnnotatedClass(Matiere.class);
				configuration.addAnnotatedClass(Module.class);
				configuration.addAnnotatedClass(Professeur.class);
				configuration.addAnnotatedClass(Reservation.class);
				configuration.addAnnotatedClass(Role.class);
				configuration.addAnnotatedClass(Salle.class);
				configuration.addAnnotatedClass(Schedule.class);
				configuration.addAnnotatedClass(Semestre.class);
				configuration.addAnnotatedClass(Session.class);
				configuration.addAnnotatedClass(Typesalle.class);
				configuration.addAnnotatedClass(User.class);
				

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}