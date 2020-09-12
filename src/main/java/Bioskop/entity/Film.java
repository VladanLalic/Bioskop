package Bioskop.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column(name="Opis")
    private String opis;

    @Column(nullable=false, name="Zanr")
    private String zanr;

    @Column (name="Trajanje")
    private String duzina;

    @Column (name="Ocena")
    private Double ocena;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getDuzina() {
        return duzina;
    }

    public void setDuzina(String duzina) {
        this.duzina = duzina;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }






    @OneToMany (mappedBy = "film",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<PogledaniFilmovi> pogledani= new HashSet<>();

    public Set<PogledaniFilmovi> getPogledani() {
        return pogledani;
    }

    public void setPogledani(Set<PogledaniFilmovi> pogledani) {
        this.pogledani = pogledani;
    }

    public Set<Projekcija> getProjekcije() {
        return projekcije;
    }

    public void setProjekcije(Set<Projekcija> projekcije) {
        this.projekcije = projekcije;
    }

    @OneToMany(mappedBy = "film")
    private  Set<Projekcija> projekcije = new HashSet<>();




    @Override
    public String toString() {
        return "Film{" +
                "naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", zanr='" + zanr + '\'' +
                ", duzina=" + duzina +
                ", ocena=" + ocena +
                '}';
    }
}
