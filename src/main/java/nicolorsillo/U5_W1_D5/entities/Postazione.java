package nicolorsillo.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Postazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(nullable = true)
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPostazione tipo;
    @Column(name = "n_max_occupanti", nullable = false)
    private int nMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int nMaxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.nMaxOccupanti = nMaxOccupanti;
        this.edificio = edificio;
    }

    public Postazione(TipoPostazione tipo, int nMaxOccupanti, Edificio edificio) {
        this.tipo = tipo;
        this.nMaxOccupanti = nMaxOccupanti;
        this.edificio = edificio;
    }
}
