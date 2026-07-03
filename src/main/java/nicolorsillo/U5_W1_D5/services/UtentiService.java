package nicolorsillo.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolorsillo.U5_W1_D5.entities.Utente;
import nicolorsillo.U5_W1_D5.exceptions.NotFoundException;
import nicolorsillo.U5_W1_D5.exceptions.ValidationException;
import nicolorsillo.U5_W1_D5.repositories.UtentiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UtentiService {

    private  final UtentiRepository utentiRepository;
    public UtentiService(UtentiRepository utentiRepository) {
        this.utentiRepository = utentiRepository;
    }

    public void saveUtente(Utente utente) {
        if (this.utentiRepository.existsByUsername(utente.getUsername())) throw new ValidationException("L'username " + utente.getUsername() + " è già in uso");

        if (this.utentiRepository.existsByEmail(utente.getEmail())) throw  new ValidationException("L'email " + utente.getEmail() + "è già in uso");

        this.utentiRepository.save(utente);

        log.info("Utente "+ utente.getUsername() + " salvato con successo");
    }

    public Utente findById(UUID id) {
        return this.utentiRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Utente findByEmail(String email) {
        return this.utentiRepository.findByEmail(email);
    }

    public List<Utente> findByUsername(String username) {
        return this.utentiRepository.findByUsernameStartingWithIgnoreCase(username);
    }

    public List<Utente> findAll() {
        return this.utentiRepository.findAll();
    }
}
