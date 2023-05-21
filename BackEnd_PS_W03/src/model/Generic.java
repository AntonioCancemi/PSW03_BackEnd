package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "generics")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoElemento", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "getByISBN", query = "SELECT g FROM Generic g WHERE g.codiceISBN= :isbn")
@NamedQuery(name = "getByAuthor", query = "SELECT g FROM Generic g WHERE g.author= :author")
@NamedQuery(name = "getByTitleLike", query = "SELECT g FROM Generic g WHERE g.title LIKE :title  ")

public class Generic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer idGeneric;
	@Column(name = "isbn")
	protected String codiceISBN;
	protected String publishYear;
	protected String title;
	protected String pages;

	public Generic() {
		super();
	}

	public Generic(String publishYear, String title, String pages) {

		this.codiceISBN = idGeneration();
		this.publishYear = publishYear;
		this.title = title;
		this.pages = pages;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Generic [idGeneric=" + idGeneric + ", codiceISBN=" + codiceISBN + ", publishYear=" + publishYear
				+ ", title=" + title + ", pages=" + pages + "]";
	}

	public String idGeneration() {

		Random rand = new Random();
		long codiceISBN = rand.nextLong(9999999999l);
		while (allItemsId.contains(String.valueOf(codiceISBN))) {
			codiceISBN = rand.nextLong(9999999999l);
		}
		allItemsId.add(String.valueOf(codiceISBN));
		return String.valueOf(codiceISBN);

	}

	private static List<String> allItemsId = new ArrayList<String>();
}
