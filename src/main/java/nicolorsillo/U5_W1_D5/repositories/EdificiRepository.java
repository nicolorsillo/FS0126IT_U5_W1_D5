package nicolorsillo.U5_W1_D5.repositories;

import nicolorsillo.U5_W1_D5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, UUID> {

    boolean existsByNomeAndIndirizzoAndCitta(String nome, String indirizzo, String citta);
}
