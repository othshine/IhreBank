package de.frauas.intro.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("A")
public class Auszahlen extends Operation {

	public Auszahlen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auszahlen(Date datumOperation, double wert, Konto konto) {
		super(datumOperation, wert, konto);
		// TODO Auto-generated constructor stub
	}
	 
	

}
