package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Utils.JpaUtil;
import model.Persona;

public class CPersonaDAO implements IPersonaDAO {

	@Override
	public void save(Persona e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// start connection
			em.getTransaction().begin();
			// add element
			em.persist(e);
			// push changes to db
			em.getTransaction().commit();
			System.out.println("Elemento salvato nel db");
		} catch (Exception e2) {
			// undo action if faild
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public Persona getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Persona ev = null;
		try {
			// start connection
			em.getTransaction().begin();
			// add element
			ev = em.find(Persona.class, id);
			// push changes to db
			em.getTransaction().commit();

		} catch (Exception e2) {
			// undo action if faild
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return ev;
	}

	@Override
	public void delete(Persona e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// start connection
			em.getTransaction().begin();
			// add element
			em.remove(e);
			// push changes to db
			em.getTransaction().commit();
			System.out.println("Elemento eliminato nel db");
		} catch (Exception e2) {
			// undo action if faild
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Persona e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// start connection
			em.getTransaction().begin();
			// add element
			em.merge(e);
			// push changes to db
			em.getTransaction().commit();
			System.out.println("Elemento update nel db");
		} catch (Exception e2) {
			// undo action if faild
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public List<Persona> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// Query q = em.createQuery("SELECT ev FROM Evento ev"); DYNAMIC
			Query q = em.createQuery("SELECT e FROM Evento e");// named query definata nella classe evento

			return q.getResultList();// List di Eventi estratti
		} finally {
			em.close();
		}
	}

}
