package de.frauas.intro.entity;

import java.util.Date;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("E")
public class Einzahlen extends Operation {

	public Einzahlen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Einzahlen(Date datumOperation, double wert, Konto konto) {
		super(datumOperation, wert, konto);
		// TODO Auto-generated constructor stub
	}

}
