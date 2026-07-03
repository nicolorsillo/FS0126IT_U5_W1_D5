package nicolorsillo.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolorsillo.U5_W1_D5.entities.Edificio;
import nicolorsillo.U5_W1_D5.exceptions.NotFoundException;
import nicolorsillo.U5_W1_D5.exceptions.ValidationException;
import nicolorsillo.U5_W1_D5.repositories.EdificiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EdificiService {
    private final EdificiRepository edificiRepository;
    public EdificiService(EdificiRepository edificiRepository) {
        this.edificiRepository = edificiRepository;
    }

    public void saveEdificio(Edificio edificio) {
        if (this.edificiRepository.existsByNomeAndIndirizzoAndCitta(edificio.getNome(),  edificio.getIndirizzo(), edificio.getCitta())) throw new ValidationException("L'edificio già esiste");

        this.edificiRepository.save(edificio);

        log.info("L'edificio " + edificio.getNome() + " è stato salvato correttamente");
    }

    public Edificio findById(UUID id) {
        return this.edificiRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public List<Edificio> findAll() {
        return this.edificiRepository.findAll();
    }
}
