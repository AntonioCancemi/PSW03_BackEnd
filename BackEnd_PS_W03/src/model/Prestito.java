package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "getPrestitoAperto", query = "SELECT p FROM Prestito p WHERE p.restituzioneEffettiva=null ORDER BY p.utente ")
@NamedQuery(name = "getPrestitoScaduto", query = "SELECT p FROM Prestito p WHERE p.restituzionePrevista < :now AND p.restituzioneEffettiva=null")
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrestito;

	private LocalDate startPrestito;
	private LocalDate restituzionePrevista;// 30gg dopo start prestito
	@Column(nullable = true)
	private LocalDate restituzioneEffettiva;
	@OneToOne
	private Persona utente;

	@OneToOne
	private Generic elementoPrestato;

	public Prestito() {
		super();
	}

	public Prestito(Persona utente, Generic elementoPrestato, LocalDate startPrestito,
			LocalDate restituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.startPrestito = startPrestito;
		this.restituzionePrevista = startPrestito.plusDays(30);
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	public Persona getUtente() {
		return utente;
	}

	public void setUtente(Persona utente) {
		this.utente = utente;
	}

	public Generic getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(Generic elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getStartPrestito() {
		return startPrestito;
	}

	public void setStartPrestito(LocalDate startPrestito) {
		this.startPrestito = startPrestito;
	}

	public LocalDate getRestituzionePrevista() {
		return restituzionePrevista;
	}

	public void setRestituzionePrevista(LocalDate restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista;
	}

	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [idPrestito=" + idPrestito + ", utente=" + utente + ", elementoPrestato=" + elementoPrestato
				+ ", startPrestito=" + startPrestito + ", restituzionePrevista=" + restituzionePrevista
				+ ", restituzioneEffettiva=" + restituzioneEffettiva + "]";
	}
}
