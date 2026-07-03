package nicolorsillo.U5_W1_D5.repositories;

import nicolorsillo.U5_W1_D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UtentiRepository extends JpaRepository<Utente, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Utente findByEmail(String email);

    List<Utente> findByUsernameStartingWithIgnoreCase(String username);
}
