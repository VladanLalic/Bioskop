package Bioskop.entity;

import javax.persistence.*;
import java.io.Serializable;

public class PogledaniFilmovi implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    PogledaniKljuc id;

    @ManyToOne
    @MapsId("korisnik_id")
    @JoinColumn(name = "film_id")
    private Korisnik korisnik;

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name = "film_id")
    private Film film;



    @Column
    private int ocena;

    public PogledaniKljuc getId() {
        return id;
    }

    public void setId(PogledaniKljuc id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }


    @Override
    public String toString() {
        return "PogledaniFilmovi{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", film=" + film +
                ", ocena=" + ocena +
                '}';
    }






}
