package nicolorsillo.U5_W1_D5.repositories;

import nicolorsillo.U5_W1_D5.entities.Postazione;
import nicolorsillo.U5_W1_D5.entities.Prenotazione;
import nicolorsillo.U5_W1_D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    boolean existsByPostazioneAndData(Postazione postazione, LocalDate dataPrenotazione);

    boolean existsByUtenteAndData(Utente utente, LocalDate dataPrenotazione);
}
