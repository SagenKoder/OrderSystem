package app.sagen.ordersystem.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// source: https://www.bring.no/radgivning/sende-noe/adressetjenester/postnummer/postnummertabeller-veiledning
@Entity
@Data
@NoArgsConstructor
public class PostNummer {

    @Id
    @Column(length = 4, nullable = false)
    private String postnummer;

    @Column(length = 32, nullable = false)
    private String poststed;

    @Column(length = 4, nullable = false)
    private String kommunekode;

    @Column(length = 30, nullable = false)
    private String kommunenavn;

    @Column(length = 1, nullable = false)
    private String kategori;

//    @JsonIgnore
//    @Version
//    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
//    private long version = 0L;


    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    public String getKommunekode() {
        return kommunekode;
    }

    public void setKommunekode(String kommunekode) {
        this.kommunekode = kommunekode;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public void setKommunenavn(String kommunenavn) {
        this.kommunenavn = kommunenavn;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
