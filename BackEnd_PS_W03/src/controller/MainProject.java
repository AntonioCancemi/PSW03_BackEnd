package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import DAO.CPersonaDAO;
import DAO.CPrestitoDAO;
import DAO.GenericDAO;
import Utils.Periodicita;
import model.Book;
import model.Magazine;
import model.Persona;
import model.Prestito;

public class MainProject {

	static EntityManager em = Persistence.createEntityManagerFactory("PS_W03").createEntityManager();

	static CPrestitoDAO prestitoDAO = new CPrestitoDAO();
	static CPersonaDAO perDAO = new CPersonaDAO();
	static GenericDAO genericDAO = new GenericDAO();
	static Scanner sc = new Scanner(System.in);
	static String[] comandsAvailable = { "CLOSE_PROGRAM", "ADD", "REMOVE", "SEARCH_ISBN", "SEARCH_AUTHOR",
			"SEARCH_YEAR" };

	public static void main(String[] args) {
		// start();
		// Prestito prestito1 = new Prestito(perDAO.getById(2), genericDAO.getById(5),
		// LocalDate.now(), null);
		// prestitoDAO.save(prestito1);
		// genericDAO.getAll().forEach(e -> System.out.println(e));
		// List<Prestito> p = prestitoDAO.getPrestitiScaduti();
		List<Prestito> p = prestitoDAO.getPrestitiAperti();
		// List<Generic> g =genericDAO.getByTitle("come");
		// List<Generic> g = genericDAO.getByAuthor("Filippo blus");
		// List<Generic> g =genericDAO.getByISBN("5550484148");
		// genericDAO.deleteByISBN("5550484148");
		p.forEach(e -> System.out.println(e)); // genericDAO.getAll();
		// System.out.println(g);
	}

	public static void start() {
		Book b1 = new Book("2005", "indiana Jhonse", "270", "Filippo blus", "adventure");
		Book b2 = new Book("2005", "Peppa pig", "30", "Ciro Esposito", "bambini");
		Book b3 = new Book("2015", "dora l'esploratrice", "70", "Carla Osti", "adventure~bambini");
		Book b4 = new Book("2007", "L'inferno di Dante", "330", "Dante Alighieri", "Commedia");
		Book b5 = new Book("2011", "L'amore", "987", "Fabio Volo", "romanzo");
		Book b6 = new Book("2020", "L'apocalisse", "450", "Nostradamus", "romanzo");
		Book b7 = new Book("2001", "bianco come la neve", "320", "Jake Trim", "thriller");
		Book b8 = new Book("1890", "Il nuovo Secolo", "170", "Sant'Agostino", "bibliografia");

		genericDAO.save(b1);
		genericDAO.save(b2);
		genericDAO.save(b3);
		genericDAO.save(b4);
		genericDAO.save(b5);
		genericDAO.save(b6);
		genericDAO.save(b7);
		genericDAO.save(b8);
		Magazine m1 = new Magazine("2012", "Alla scoperte dell'Italia", Periodicita.SETTIMANALE, "30");
		Magazine m2 = new Magazine("2000", "Playboy", Periodicita.MENSILE, "30");
		Magazine m3 = new Magazine("2000", "Gazzetta dello Sport", Periodicita.SETTIMANALE, "30");
		Magazine m4 = new Magazine("1970", "La republica", Periodicita.MENSILE, "30");
		Magazine m5 = new Magazine("1919", "Famosi", Periodicita.SEMESTRALE, "30");
		Magazine m6 = new Magazine("2020", "Vanity Fair", Periodicita.SEMESTRALE, "30");
		Magazine m7 = new Magazine("2016", "EsseMagazine", Periodicita.SETTIMANALE, "30");
		Magazine m8 = new Magazine("2008", "TVpiu", Periodicita.SETTIMANALE, "30");
		genericDAO.save(m1);
		genericDAO.save(m2);
		genericDAO.save(m3);
		genericDAO.save(m4);
		genericDAO.save(m5);
		genericDAO.save(m6);
		genericDAO.save(m7);
		genericDAO.save(m8);
		Persona p1 = new Persona("Mario", "Rossi", LocalDate.of(1999, 9, 9));
		Persona p2 = new Persona("Stella", "Torres", LocalDate.of(1980, 10, 16));
		perDAO.save(p1);
		perDAO.save(p2);
		Prestito prestito2 = new Prestito(perDAO.getById(2), genericDAO.getById(14), LocalDate.now(), null);
		Prestito prestito3 = new Prestito(perDAO.getById(2), genericDAO.getById(7), LocalDate.of(2023, 5, 7),
				LocalDate.of(2023, 5, 21));
		Prestito prestito4 = new Prestito(perDAO.getById(2), genericDAO.getById(4), LocalDate.of(2023, 3, 21),
				LocalDate.of(2023, 4, 27));
		Prestito prestito1 = new Prestito(perDAO.getById(1), genericDAO.getById(3), LocalDate.now(), null);
		Prestito prestito5 = new Prestito(perDAO.getById(1), genericDAO.getById(6), LocalDate.of(2023, 12, 1), null);
		prestitoDAO.save(prestito2);
		prestitoDAO.save(prestito3);
		prestitoDAO.save(prestito4);
		prestitoDAO.save(prestito5);
		prestitoDAO.save(prestito1);
	}

}
