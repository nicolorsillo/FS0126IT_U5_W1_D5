package nicolorsillo.U5_W1_D5.config;

import nicolorsillo.U5_W1_D5.entities.Edificio;
import nicolorsillo.U5_W1_D5.entities.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

public class AppConfig {
    @Bean(name = "Hulk")
    public Utente getHulk() {
        return new Utente("Hulk", "Bruce", "Banner", "hulkspacca@gmail.com");
    }

    @Bean(name = "IronMan")
    public Utente getIronMan() {
        return new Utente("Iron Man", "Tony", "Stark", "t.stark@starkindustries.com");
    }

    @Bean(name = "CaptainAmerica")
    public Utente getCaptainAmerica() {
        return new Utente("Captain America", "Steve", "Rogers", "nonsocosaeunemail@gmail.com");
    }

    @Bean(name = "BlackWidow")
    public Utente getBlackWidow() {
        return new Utente("Black Widow", "Natasha", "Romanoff", "n.romanoff@shield.gov");
    }

    @Bean(name = "Hawkeye")
    public Utente getHawkeye() {
        return new Utente("Hawkeye", "Clint", "Barton", "c.barton@shield.gov");
    }

    @Bean(name = "Thor")
    public Utente getThor() {
        return new Utente("Thor", "Thor", "Figlio di Odino", "iosonothorfigliodiodino@gmail.com");
    }

    @Bean(name = "AvengersTower")
    public Edificio getAvengersTower() {
        return new Edificio("Avengers Tower", "200 Park Avenue", "New York");
    }

    @Bean(name = "SanctumSanctorum")
    public Edificio getSanctumSanctorum() {
        return new Edificio("Sanctum Sanctorum", "177A Bleecker Street", "New York");
    }

    @Bean(name = "Triskelion")
    public Edificio getTriskelion() {
        return new Edificio("Triskelion", "Theodore Roosevelt Island", "Washington D.C.");
    }


}
