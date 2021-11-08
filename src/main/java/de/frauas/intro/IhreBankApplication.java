package de.frauas.intro;




import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.frauas.intro.DAO.KontoRepository;
import de.frauas.intro.DAO.KundeRepository;
import de.frauas.intro.entity.Konto;
import de.frauas.intro.entity.Kunde;


@SpringBootApplication
public class IhreBankApplication  implements CommandLineRunner{
	@Autowired
	private KontoRepository kontorepo;
	@Autowired
	private KundeRepository kunderepo;
	public static void main(String[] args) {
		SpringApplication.run(IhreBankApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 Daten zu testen
		 */
		Kunde kunde1 = new Kunde("Othmane","othmane@mail.com");
		Kunde kunde2 = new Kunde("Khalid","othmane@mail.com");
		Kunde kunde3 = new Kunde("Yacine","othmane@mail.com");
		kunderepo.save(kunde1);
		kunderepo.save(kunde2);
		kunderepo.save(kunde3);
		Konto konto1 = new Konto("k1",new Date(),1500,kunde1);
		Konto konto2 = new Konto("k2",new Date(),15000,kunde2);
		Konto konto3 = new Konto("k3",new Date(),100,kunde3);
		kontorepo.save(konto1);
		kontorepo.save(konto2);
		kontorepo.save(konto3);
		
	}



}
