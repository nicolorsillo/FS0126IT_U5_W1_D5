package nicolorsillo.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false)
    private LocalDate data;
    @Column(name = "numero_occupanti", nullable = false)
    private int numeroOccupanti;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    public Prenotazione(LocalDate data, int numeroOccupanti, Utente utente, Postazione postazione) {
        this.data = data;
        this.numeroOccupanti = numeroOccupanti;
        this.utente = utente;
        this.postazione = postazione;
    }
}
