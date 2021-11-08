package de.frauas.intro.entity;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * 
 * @author othma
 *
 */
/**Kunde ist eine Klasse von unserem E/R Diagramm
 * hat eine Beziehung Konto oneToMany mit Konnten
 * Der Id ist automatisch generiert.
 * Serializable umzu einem File zu übertragen
 * getters und setters und Konstruktor 
 */
@SuppressWarnings("serial")
@Entity
public class Kunde implements Serializable{
	@Id @GeneratedValue
	private Long code;
	private String name;
	private String mail;
	@OneToMany(mappedBy="kunde",fetch=FetchType.LAZY)
	private Collection<Konto> konten;
	public Kunde(String name, String mail) {
		super();
		this.name = name;
		this.mail = mail;
	}
	public Kunde() {
		super();
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Collection<Konto> getKonten() {
		return konten;
	}
	public void setKonten(Collection<Konto> konten) {
		this.konten = konten;
	}
	
	

}
