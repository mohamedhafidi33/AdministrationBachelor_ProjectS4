package dao;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.*;
import dao.IProfesseurDAO;
import util.HibernateUtil;

public class IProfesseurImplDAO implements IProfesseurDAO {
	
	public void ajouterProfesseur(Professeur Prof,User userP ) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// operation 1
			Object object = session.save(Prof);
			object = session.save(userP);
			
			
			// operation 2
			session.get(Professeur.class, (Serializable) object);
			
			// commit transaction
			transaction.commit();
		} catch (RuntimeException e) {
            if ( transaction != null && transaction.isActive() ) 
                transaction.rollback();
            throw e;
        }
		
		
	}
	
	
	

	public void modifierProfesseur(Professeur prof) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			String hql = "UPDATE Prof set cin = :cin " + "WHERE id = :id";
			Query query = session.createQuery(hql);
			
			query.setParameter("id", 1);
			query.setParameter("nom", prof.getNom());
			query.setParameter("prénom", prof.getPrenom());
			query.setParameter("CIN", prof.getCin());
			query.setParameter("sexe",prof.getSexe());
			//.... and so on
			
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public void supprimerProfesseur (int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a student object
			Etudiant etudiant = session.get(Etudiant.class, id);
			if (etudiant != null) {
				String hql = "DELETE FROM Professeur " + "WHERE id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				int result = query.executeUpdate();
				System.out.println("Rows affected: " + result);
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	
}