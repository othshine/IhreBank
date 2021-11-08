package de.frauas.intro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import de.frauas.intro.entity.Kunde;
/**
 * @author othma
verbindung mit der Datenbank IN UNSEREM fALL mySQLServerund DATEN ZU PBERTRAGEN
 */
public interface KundeRepository extends JpaRepository<Kunde, Long>{

}
