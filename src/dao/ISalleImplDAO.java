package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Salle;
import util.HibernateUtil;

public class ISalleImplDAO implements ISalleDAO {
	
	public void saveSalle(Salle salle) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// operation 1
			Object object = session.save(salle);
			
			// operation 2
			session.get(Salle.class, (Serializable) object);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	

	public void updateSalle(Salle salle) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			String hql = "UPDATE Salle set description = :description " + "WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("numero", salle.getNumero());
			query.setParameter("description", salle.getDescription());
			query.setParameter("id", 1);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteSalle(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a student object
			Salle salle = session.get(Salle.class, id);
			if (salle != null) {
				String hql = "DELETE FROM Salle " + "WHERE id = :id";
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
			e.printStackTrace();
		}
	}

	
}