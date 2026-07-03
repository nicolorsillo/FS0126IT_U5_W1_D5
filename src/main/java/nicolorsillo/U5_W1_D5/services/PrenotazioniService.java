package nicolorsillo.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolorsillo.U5_W1_D5.entities.Prenotazione;
import nicolorsillo.U5_W1_D5.entities.Utente;
import nicolorsillo.U5_W1_D5.exceptions.NotFoundException;
import nicolorsillo.U5_W1_D5.exceptions.ValidationException;
import nicolorsillo.U5_W1_D5.repositories.PrenotazioniRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PrenotazioniService {

    private final PrenotazioniRepository prenotazioniRepository;

    public PrenotazioniService(PrenotazioniRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }

    public void savePrenotazione(Prenotazione prenotazione) {
        if(this.prenotazioniRepository.existsByPostazioneAndData(prenotazione.getPostazione(), prenotazione.getData())) throw new ValidationException("Postazione occupata");

        if(this.prenotazioniRepository.existsByUtenteAndData(prenotazione.getUtente(), prenotazione.getData())) throw new ValidationException("L'utente " + prenotazione.getUtente().getUsername() + " ha già una prenotazione in questa data");

        this.prenotazioniRepository.save(prenotazione);

        log.info("La prenotazione di "+ prenotazione.getUtente().getUsername() +", per il giorno " + prenotazione.getData() + " nella postazione del " + prenotazione.getPostazione().getEdificio().getNome() + " e stata salvata con successo");
    }

    public Prenotazione findById(UUID id) {
        return  this.prenotazioniRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public List<Prenotazione> findAll() {
        return this.prenotazioniRepository.findAll();
    }


}
