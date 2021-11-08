package de.frauas.intro.entity;
/**Die Klasse Operation hat eine ManyToOne Beziehung mit Konto
 * @DisciminatorColumn Ein Spalte hinzufügen um die Operationen (Auszahlen/Einzahlen)zu unterscheiden
 * Außerden nur Geteers und Setters und Konstruktror
 * 
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPERATION",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable {
	@Id @GeneratedValue
	private Long nummer;
	private Date datumOperation;
	private double wert;
	@ManyToOne
	@JoinColumn(name="CODE_KONTO")
	private Konto konto;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date datumOperation, double wert, Konto konto) {
		super();
		this.datumOperation = datumOperation;
		this.wert = wert;
		this.konto = konto;
	}
	public Long getNummer() {
		return nummer;
	}
	public void setNummer(Long nummer) {
		this.nummer = nummer;
	}
	public Date getDatumOperation() {
		return datumOperation;
	}
	public void setDatumOperation(Date datumOperation) {
		this.datumOperation = datumOperation;
	}
	public double getWert() {
		return wert;
	}
	public void setWert(double wert) {
		this.wert = wert;
	}
	public Konto getKonto() {
		return konto;
	}
	public void setKonto(Konto konto) {
		this.konto = konto;
	} 
	 
	

}
