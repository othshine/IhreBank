package de.frauas.intro.KontoServices;



import java.util.Optional;


import org.springframework.data.domain.Page;

import de.frauas.intro.entity.Konto;
import de.frauas.intro.entity.Operation;
/**
 * @author othma
 * Alle Operationen die notwendig für unsere WebAnwendung sing werden in dieser Interface repräsentiert.
 * Werden zunächst in einer Service (BankOperations)implementiert
 * infosKonto Information eines Kontos zu darzustellen
 * einzahlen --> Geld in einem Konto einzahlen
 * auszahlen -->Geld in einem Konto auszahlen
 * überweisen-->  geld von einem Konto zu einem anderen Konto überweisen
 * listOperations -->Verlauf der Operationen in einem Konto
 */

public interface IBankOperations {
	public Optional<Konto> infosKonto(String kontoCode);
	public void einzahlen(String kontoCode,double wert);
	public void auszahlen(String kontoCode,double wert);
	public void überweisen(String kontoCode1,String kontoCode2,double wert);
	public Page<Operation> listOperations(String kontocode,int page,int size);

	

}
