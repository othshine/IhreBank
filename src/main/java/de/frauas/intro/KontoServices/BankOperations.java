package de.frauas.intro.KontoServices;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import de.frauas.intro.DAO.KontoRepository;
import de.frauas.intro.DAO.OperationRepository;
import de.frauas.intro.entity.Auszahlen;
import de.frauas.intro.entity.Einzahlen;
import de.frauas.intro.entity.Konto;
import de.frauas.intro.entity.Operation;
@Service
@Transactional
/**
 * @author othma
 Die Funktionen sind hier in dieser Klasse interpretiert
 */
public class BankOperations implements IBankOperations{
 
	@Autowired
	private KontoRepository kontorepo;
    @Autowired
    private OperationRepository operationrepo;
	/**
	 Die infos von eniem Konto abrufen von Datenbank
	 */
	public Optional<Konto> infosKonto(String kontoCode) {
		Optional<Konto> kontotest;
		kontotest=kontorepo.findById(kontoCode);
		if(kontotest.equals(null)) return null;		
		return kontotest;
	}

	/**
	 Addiriren den Beitrag auf dem Konto
	 
	 */
	public void einzahlen(String kontoCode, double wert) {
           Optional<Konto> kontotest=infosKonto(kontoCode);
           Einzahlen ein=new Einzahlen(new Date(), wert, kontotest.get());
           operationrepo.save(ein);
           kontotest.get().setKontostand(kontotest.get().getKontostand()+wert);
           kontorepo.save(kontotest.get());
           
           /**
            Susbratrien den Beitrag von dem Konto
            Und Überprüfung od Die Summe ist verfügbar auszuzahlen
            
            */
	}
	public void auszahlen(String kontoCode, double wert) {
		 Optional<Konto> kontotest=infosKonto(kontoCode);
         Auszahlen aus=new Auszahlen(new Date(), wert, kontotest.get());
         if(aus.getWert()>kontotest.get().getKontostand())
         throw new RuntimeException("Die Summe ist nicht verfügbar");
         operationrepo.save(aus);
         kontotest.get().setKontostand(kontotest.get().getKontostand()-wert);
         kontorepo.save(kontotest.get());		
	}

	/**
	 Die Überweisung ist ein einfaches Auszahlen dann Einzahlen
	 */
	public void überweisen(String kontogenommen, String kontobekommen, double wert) {
		auszahlen(kontogenommen,wert);
		einzahlen(kontobekommen,wert);
		}
	/**
	 Abruf der Operationen  einem Konto
	 und Sortierung nach Datum Operationen
	 */

	public Page<Operation> listOperations(String kontocode,int page,int size) {
		Pageable pageable=PageRequest.of(page, size,Sort.by("datumOperation").descending());
		return operationrepo.findAll(pageable);	
		
	}

}
