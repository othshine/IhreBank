package de.frauas.intro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import de.frauas.intro.entity.Konto;
/**
 * @author othma
verbindung mit der Datenbank IN UNSEREM fALL mySQLServerund DATEN ZU PBERTRAGEN
 */
public interface KontoRepository extends JpaRepository<Konto, String>{
  

}
