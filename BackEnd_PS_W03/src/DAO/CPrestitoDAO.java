package DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Utils.JpaUtil;
import model.Prestito;

public class CPrestitoDAO implements IPrestitoDAO {

	@Override
	public void save(Prestito e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// start connection
			System.out.println(e);
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
	public Prestito getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			// start connection
			em.getTransaction().begin();
			// add element
			Prestito ev = em.find(Prestito.class, id);
			// push changes to db
			em.getTransaction().commit();
			return ev;
		} catch (Exception e2) {
			// undo action if faild
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;

	}

	@Override
	public void delete(Prestito e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// start connection
			em.getTransaction().begin();
			// add element
			System.out.println(e);
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
	public void update(Prestito e) {
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
	public List<Prestito> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// Query q = em.createQuery("SELECT ev FROM Evento ev"); DYNAMIC
			Query q = em.createQuery("SELECT e FROM Evento e");// named query definata nella classe evento

			return q.getResultList();// List di Eventi estratti
		} finally {
			em.close();
		}
	}

	public List<Prestito> getPrestitiAperti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			// Query q = em.createQuery("SELECT ev FROM Evento ev"); DYNAMIC
			Query q = em.createNamedQuery("getPrestitoAperto");

			return q.getResultList();// List di Eventi estratti
		} finally {
			em.close();
		}
	}

	public List<Prestito> getPrestitiScaduti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		LocalDate now = LocalDate.now();
		try {
			// Query q = em.createQuery("SELECT ev FROM Evento ev"); DYNAMIC
			Query q = em.createNamedQuery("getPrestitoScaduto").setParameter("now", now);

			return q.getResultList();// List di Eventi estratti
		} finally {
			em.close();
		}
	}

}
