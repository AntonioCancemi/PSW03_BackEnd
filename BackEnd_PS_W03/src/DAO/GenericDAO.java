package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Utils.JpaUtil;
import model.Generic;

public class GenericDAO {
	public void save(Generic e) {
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

	public void delete(Generic e) {
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

	public void deleteByISBN(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Generic toDelete = getByISBN(isbn);
			System.out.println(toDelete);
			em.getTransaction().begin();
			em.remove(toDelete);
			em.getTransaction().commit();
			System.out.println("Elemento eliminato nel db");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Generic getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Generic g = null;
		try {
			// start connection
			em.getTransaction().begin();
			// add element
			g = em.find(Generic.class, id);
			// push changes to db
			em.getTransaction().commit();
		} catch (Exception e2) {
			// undo action if faild
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return g;
	}

	public Generic getByISBN(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Query q = em.createNamedQuery("getByISBN");// named query definata nella classe evento
			q.setParameter("title", isbn);
			List<Generic> g = q.getResultList();
			return g.get(0);
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il recupero dell'elemento...");
		} finally {
			em.close();
		}
		return null;

	}

	public Generic getByAuthor(String author) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Query q = em.createNamedQuery("getByAuthor");// named query definata nella classe evento
			q.setParameter("author", author);
			List<Generic> g = q.getResultList();
			return g.get(0);
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il recupero dell'elemento...");
		} finally {
			em.close();
		}
		return null;

	}

	public List<Generic> getByTitle(String title) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			List<Generic> g = em.createNamedQuery("getByTitleLike").setParameter("title", "%" + title + "%")
					.getResultList();

			return g;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il recupero dell'elemento...");
		} finally {
			em.close();
		}
		return null;

	}

	public List<Generic> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT g FROM Generic g");// named query definata nella classe evento
			List<Generic> g = q.getResultList();
			// g.forEach(e -> System.out.println(e));
			return g;// List di Eventi estratti
		} finally {
			em.close();
		}
	}
}
