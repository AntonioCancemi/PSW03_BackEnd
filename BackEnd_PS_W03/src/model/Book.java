package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("book")
@NamedQuery(name = "getByISBNbook", query = "SELECT g FROM Book g WHERE g.codiceISBN LIKE :codiceISBN")
public class Book extends Generic {
	private String author;
	private String genre;

	public Book() {
		super();
	}

	public Book(String publishYear, String title, String pages, String author, String genre) {
		super(publishYear, title, pages);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book" + super.toString() + "[author=" + author + ", genre=" + genre + "]";
	}
}
