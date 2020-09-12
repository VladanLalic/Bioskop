package Bioskop.entity;

import javax.persistence.*;
import java.util.*;

public class Projekcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_filma",nullable = false)
    private Film film;

    @Column
    private Date datum;

    @Column
    private double cena;


    @Column
    private int rezervisanaKarta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getRezervisanaKarta() {
        return rezervisanaKarta;
    }

    public void setRezervisanaKarta(int rezervisanaKarta) {
        this.rezervisanaKarta = rezervisanaKarta;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<Korisnik> getKorisnikRez() {
        return korisnikRez;
    }

    public void setKorisnikRez(Set<Korisnik> korisnikRez) {
        this.korisnikRez = korisnikRez;
    }

    @ManyToMany (mappedBy = "projekcije")
    private Set<Sala> sale= new HashSet<>();

    @ManyToMany(mappedBy = "rezervisana")
    private  Set<Korisnik> korisnikRez= new HashSet<>();

    @Override
    public String toString() {
        return "Projekcija{" +
                "id=" + id +
                ", film=" + film +
                ", datum=" + datum +
                ", cena=" + cena +
                ", rezervisanaKarta=" + rezervisanaKarta +
                ", sale=" + sale +
                '}';
    }
}
