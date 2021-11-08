package de.frauas.intro.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * @author othma
 *
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
 /**
  * Die Klasse Konto hat eine Beziehung MANYTOONE mit der Klasse Kunde 
  * Die Klasse hat auch ein Beziehung  OnetoMany mit der Klasse Operation
  * @joinCloumn Das ist den Foreign Key mit der Klasse Kunde
  * @Inheritance als Singletable um zu vereinfachen und war Empfehlung von Forum
  * @Serializable Möglichkeit in File zu übertragen
  * Außerdem nur Konstruktor und Getters und Setters
  
  */
public class Konto  implements Serializable{
	@Id
    private String kontoCode;
    private Date erstellungsdatum;
    private double kontostand;
    @ManyToOne
    @JoinColumn(name="Code_Kunde")
    private Kunde kunde;
    @OneToMany(mappedBy="konto")
    private Collection<Operation> operations;
	public Konto() {
		super();
		
	}
	public Konto(String kontoCode, Date erstellungsdatum, double kontostand, Kunde kunde) {
		super();
		this.kontoCode = kontoCode;
		this.erstellungsdatum = erstellungsdatum;
		this.kontostand = kontostand;
		this.kunde = kunde;
	}
	public String getKontoCode() {
		return kontoCode;
	}
	public void setKontoCode(String kontoCode) {
		this.kontoCode = kontoCode;
	}
	public Date getErstellungsdatum() {
		return erstellungsdatum;
	}
	public void setErstellungsdatum(Date erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}
	public double getKontostand() {
		return kontostand;
	}
	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
    
    
    
	

}
