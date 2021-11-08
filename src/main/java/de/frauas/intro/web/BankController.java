package de.frauas.intro.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.frauas.intro.KontoServices.IBankOperations;
import de.frauas.intro.entity.Konto;
import de.frauas.intro.entity.Operation;

@Controller
public class BankController {
	@Autowired
	private IBankOperations ibank;
    /**
     * Get die Websiete Konten um den iNPUT Von Konto Code eingeben und die Interface zu zeigen
     * 
     * @return 
     */
	@GetMapping(value = "/konten")
	public String index() {
		return "konten";
	}
	
    /**
     * Die Darstellung von Informationen von dem Konto
     * und auch die Operationen durch die Methoden von IBankOperationen
     * KontoCode wird von einem input html abgerufen
     * Handlung von erreur wenn Das Konto ist nicht gefunden  
     * 
     */
	@GetMapping(value = "/kontoKonsultieren")
	public String eintreten(Model model, String KontoCode) {
		model.addAttribute("KontoCode", KontoCode);
		Optional<Konto> kontozuZeigen = ibank.infosKonto(KontoCode);
		if (kontozuZeigen.isEmpty()) {
			String errormessage = "Konto nicht gefunden";
			model.addAttribute("message", errormessage);
			return "konten";
		} else {
			Page<Operation> pageOperationen = ibank.listOperations(KontoCode, 0, 4);
			model.addAttribute("listOperationen", pageOperationen.getContent());
			model.addAttribute("konto", kontozuZeigen.get());
			return "konten";
		}
	}
	/**
	 * 
	 * @param model
	 * @param typOperation Selekitierung vom typOperation durch Thymleaf
	 * @param KontoCode 
	 * @param betrag Lesen den Input "Betrag" VOM Thymleaf
	 * @param KontoCode2 Lesen den Input des Code ,den Betrag zu überweisen
	 * @return Redirect zu Kontokonsultieren um die Operationene zu aktualiesern
	 */
	@PostMapping(value ="/speichernOperation")
	public String speichernOperation(Model model,String typOperation,String KontoCode,double betrag,String KontoCode2) {
		if(typOperation.equals("EIN")) 
			ibank.einzahlen(KontoCode, betrag);
		else if(typOperation.equals("AUS")) {
		try{
			ibank.auszahlen(KontoCode, betrag);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			model.addAttribute("Error", e);
			return"redirect:/kontoKonsultieren?KontoCode="+KontoCode+"&Error="+e.getMessage();
			}
		}
		if(typOperation.equals("UBER"))
			ibank.überweisen(KontoCode, KontoCode2, betrag);	 
		return"redirect:/kontoKonsultieren?KontoCode="+KontoCode;
	}
}
