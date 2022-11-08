package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain;

import javax.persistence.*;

@Entity
@Table(name="flors")
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer pk_FlorID;


    private String nomFlor;
    private String paisFlor;

    public FlorEntity() {
    }

    /* Getters & Setters */
    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}
