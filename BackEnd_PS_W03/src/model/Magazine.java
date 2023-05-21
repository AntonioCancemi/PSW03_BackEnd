package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Utils.Periodicita;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Generic {
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Magazine(String publishYear, String title, Periodicita period, String pages) {
		super(publishYear, title, pages);
		this.periodicita = period;

	}

	public Magazine() {
		super();
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Magazine " + super.toString() + "[periodicita=" + periodicita + "]";
	}
}
