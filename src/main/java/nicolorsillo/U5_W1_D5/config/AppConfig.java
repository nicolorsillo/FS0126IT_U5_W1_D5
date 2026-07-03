package nicolorsillo.U5_W1_D5.config;

import nicolorsillo.U5_W1_D5.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.time.Month;

@Configuration

public class AppConfig {

    //Utenti
    @Bean(name = "hulk")
    public Utente getHulk() {
        return new Utente("Hulk", "Bruce", "Banner", "hulkspacca@gmail.com");
    }

    @Bean(name = "ironMan")
    public Utente getIronMan() {
        return new Utente("Iron Man", "Tony", "Stark", "t.stark@starkindustries.com");
    }

    @Bean(name = "captainAmerica")
    public Utente getCaptainAmerica() {
        return new Utente("Captain America", "Steve", "Rogers", "nonsocosaeunemail@gmail.com");
    }

    @Bean(name = "blackWidow")
    public Utente getBlackWidow() {
        return new Utente("Black Widow", "Natasha", "Romanoff", "n.romanoff@shield.gov");
    }

    @Bean(name = "hawkeye")
    public Utente getHawkeye() {
        return new Utente("Hawkeye", "Clint", "Barton", "c.barton@shield.gov");
    }

    @Bean(name = "thor")
    public Utente getThor() {
        return new Utente("Thor", "Thor", "Figlio di Odino", "iosonothorfigliodiodino@gmail.com");
    }

    // Edifici
    @Bean(name = "avengersTower")
    public Edificio getAvengersTower() {
        return new Edificio("Avengers Tower", "200 Park Avenue", "New York");
    }

    @Bean(name = "sanctumSanctorum")
    public Edificio getSanctumSanctorum() {
        return new Edificio("Sanctum Sanctorum", "177A Bleecker Street", "New York");
    }

    @Bean(name = "triskelion")
    public Edificio getTriskelion() {
        return new Edificio("Triskelion", "Theodore Roosevelt Island", "Washington D.C.");
    }

    //Postazioni

    @Bean(name = "atticoAT")
    public Postazione getAtticoAT() {
        return new Postazione("Bellissimo Attico raggiungibile da ascensore", TipoPostazione.OPENSPACE, 10, getAvengersTower());
    }

    @Bean(name = "scrivaniaT")
    public Postazione getScrivaniaT() {
        return new Postazione(TipoPostazione.PRIVATO, 1, getTriskelion());
    }

    @Bean(name = "segreteSS")
    public Postazione getSegreteSS() {
        return new Postazione("Ampia sala riunioni con celle per colleghi poco affidabili", TipoPostazione.SALA_RIUNIONI, 8, getSanctumSanctorum());
    }

    //Prenotazioni

    @Bean(name = "avengersAsseble")
    public Prenotazione getAvengersAsseble() {
        return new Prenotazione(LocalDate.of(2026, Month.JULY, 3), 8, getIronMan(), getAtticoAT());
    }

    @Bean(name = "giornataDiLavoro")
    public Prenotazione getGiornataDiLavoro() {
        return new Prenotazione(LocalDate.of(2026, Month.JULY, 2), 1, getHawkeye(), getScrivaniaT());
    }

    @Bean(name = "aRaccoltaDaDtStrange")
    public Prenotazione getARaccoltaDaDtStrange() {
        return new Prenotazione(LocalDate.of(2026, Month.JULY, 4), 5, getThor(), getSegreteSS());
    }
}
