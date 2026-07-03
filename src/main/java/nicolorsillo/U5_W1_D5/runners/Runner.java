package nicolorsillo.U5_W1_D5.runners;

import nicolorsillo.U5_W1_D5.entities.Postazione;
import nicolorsillo.U5_W1_D5.entities.Prenotazione;
import nicolorsillo.U5_W1_D5.entities.TipoPostazione;
import nicolorsillo.U5_W1_D5.entities.Utente;
import nicolorsillo.U5_W1_D5.services.EdificiService;
import nicolorsillo.U5_W1_D5.services.PostazioniService;
import nicolorsillo.U5_W1_D5.services.PrenotazioniService;
import nicolorsillo.U5_W1_D5.services.UtentiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final UtentiService utentiService;
    private final EdificiService edificiService;
    private final PostazioniService postazioniService;
    private final PrenotazioniService prenotazioniService;
    private final ApplicationContext ctx;

    public Runner(UtentiService utentiService, EdificiService edificiService,
                      PostazioniService postazioniService, PrenotazioniService prenotazioniService,
                      ApplicationContext ctx) {
        this.utentiService = utentiService;
        this.edificiService = edificiService;
        this.postazioniService = postazioniService;
        this.prenotazioniService = prenotazioniService;
        this.ctx = ctx;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- TEST 1: Ricerca postazioni per Tipo e Città ---");

        TipoPostazione tipoCercato = TipoPostazione.SALA_RIUNIONI;
        String cittaCercata = "New York";

        List<Postazione> postazioniTrovate = postazioniService.findByTipoAndCitta(tipoCercato, cittaCercata);
        postazioniTrovate.forEach(p -> System.out.println(" - ID: " + p.getId() + " presso " + p.getEdificio().getNome()));

        System.out.println("--- TEST 2: Tentativo più prenotazione nello stesso giorno da una stessa persona ---");
        try {

            Utente ironMan = ctx.getBean("ironMan", Utente.class);
            Postazione scrivaniaT = ctx.getBean("scrivaniaT", Postazione.class);
            LocalDate dataGiaOccupata = LocalDate.of(2026, Month.JULY, 3);

            Prenotazione nuovaPrenotazione = new Prenotazione(dataGiaOccupata, 1, ironMan, scrivaniaT);

            prenotazioniService.savePrenotazione(nuovaPrenotazione);
        } catch (Exception e) {
            System.out.println("Non puoi avere più prenotazioni lo stesso giorno");
        }
    }
}