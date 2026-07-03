package nicolorsillo.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolorsillo.U5_W1_D5.entities.Postazione;
import nicolorsillo.U5_W1_D5.entities.TipoPostazione;
import nicolorsillo.U5_W1_D5.exceptions.NotFoundException;
import nicolorsillo.U5_W1_D5.repositories.PostazioniRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PostazioniService {

    private final PostazioniRepository postazioniRepository;

    public PostazioniService(PostazioniRepository postazioniRepository) {
        this.postazioniRepository = postazioniRepository;
    }

    public void savePostazione(Postazione postazione) {
        this.postazioniRepository.save(postazione);
        log.info("Postazione " + postazione.getId() + " salvata con successo");
    }

    public Postazione findById(UUID id) {
        return this.postazioniRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public List<Postazione> findAll() {
        return this.postazioniRepository.findAll();
    }

    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
        return this.postazioniRepository.cercaPerTipoECitta(tipo, citta);
    }
}
