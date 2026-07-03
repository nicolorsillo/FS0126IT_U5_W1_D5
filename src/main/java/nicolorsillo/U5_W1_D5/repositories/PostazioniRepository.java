package nicolorsillo.U5_W1_D5.repositories;

import nicolorsillo.U5_W1_D5.entities.Postazione;
import nicolorsillo.U5_W1_D5.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p JOIN p.edificio e WHERE p.tipo = :tipo AND e.citta = :citta")
    List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta);
}
