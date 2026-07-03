//package nicolorsillo.U5_W1_D5.runners;
//
//import nicolorsillo.U5_W1_D5.entities.Edificio;
//import nicolorsillo.U5_W1_D5.entities.Postazione;
//import nicolorsillo.U5_W1_D5.entities.Prenotazione;
//import nicolorsillo.U5_W1_D5.entities.Utente;
//import nicolorsillo.U5_W1_D5.services.EdificiService;
//import nicolorsillo.U5_W1_D5.services.PostazioniService;
//import nicolorsillo.U5_W1_D5.services.PrenotazioniService;
//import nicolorsillo.U5_W1_D5.services.UtentiService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SaveRunner implements CommandLineRunner {
//
//    private final EdificiService edificiService;
//    private final PostazioniService postazioniService;
//    private final PrenotazioniService prenotazioniService;
//    private final UtentiService utentiService;
//    private final ApplicationContext ctx;
//
//    public SaveRunner(EdificiService edificiService, PostazioniService postazioniService, PrenotazioniService prenotazioniService, UtentiService utentiService, ApplicationContext ctx) {
//        this.edificiService = edificiService;
//        this.postazioniService = postazioniService;
//        this.prenotazioniService = prenotazioniService;
//        this.utentiService = utentiService;
//        this.ctx = ctx;
//    }
//    @Override
//    public void run(String... args) throws Exception {
//        try {
//            Utente ironMan = ctx.getBean("ironMan", Utente.class);
//            Utente hulk = ctx.getBean("hulk", Utente.class);
//            Utente thor = ctx.getBean("thor", Utente.class);
//            Utente hawkeye = ctx.getBean("hawkeye", Utente.class);
//            Utente blackWidow = ctx.getBean("blackWidow", Utente.class);
//            Utente captainAmerica = ctx.getBean("captainAmerica", Utente.class);
//            utentiService.saveUtente(ironMan);
//            utentiService.saveUtente(hulk);
//            utentiService.saveUtente(hawkeye);
//            utentiService.saveUtente(thor);
//            utentiService.saveUtente(captainAmerica);
//            utentiService.saveUtente(blackWidow);
//
//            Edificio avengersTower = ctx.getBean("avengersTower", Edificio.class);
//            Edificio sanctumSanctorum = ctx.getBean("sanctumSanctorum", Edificio.class);
//            Edificio triskelion =  ctx.getBean("triskelion", Edificio.class);
//            edificiService.saveEdificio(avengersTower);
//            edificiService.saveEdificio(sanctumSanctorum);
//            edificiService.saveEdificio(triskelion);
//
//            Postazione atticoAT = ctx.getBean("atticoAT", Postazione.class);
//            Postazione scrivaniaT = ctx.getBean("scrivaniaT", Postazione.class);
//            Postazione segreteSS = ctx.getBean("segreteSS", Postazione.class);
//            postazioniService.savePostazione(atticoAT);
//            postazioniService.savePostazione(scrivaniaT);
//            postazioniService.savePostazione(segreteSS);
//
//            Prenotazione avengersAsseble = ctx.getBean("avengersAsseble", Prenotazione.class);
//            Prenotazione giornataDiLavoro = ctx.getBean("giornataDiLavoro", Prenotazione.class);
//            Prenotazione aRaccoltaDaDtStrange = ctx.getBean("aRaccoltaDaDtStrange", Prenotazione.class);
//            prenotazioniService.savePrenotazione(avengersAsseble);
//            prenotazioniService.savePrenotazione(giornataDiLavoro);
//            prenotazioniService.savePrenotazione(aRaccoltaDaDtStrange);
//
//        }catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }
//
//    }
//}
