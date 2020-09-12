package Bioskop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String oznaka;

    @Column
    private Double kapacitet;

    public Double getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Double kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public Bioskop getBioskop() {
        return bioskop;
    }

    public void setBioskop(Bioskop bioskop) {
        this.bioskop = bioskop;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bioskop_id",nullable = false)
    private Bioskop bioskop;

    public Set<Projekcija> getProjekcije() {
        return projekcije;
    }

    public void setProjekcije(Set<Projekcija> projekcije) {
        this.projekcije = projekcije;
    }

    @ManyToMany
    @JoinTable(name="raspored_projekcija",joinColumns =
    @JoinColumn(name="id_sale",referencedColumnName ="id"),
    inverseJoinColumns = @JoinColumn(name = "id_projekcije",referencedColumnName = "id"))
    private Set<Projekcija> projekcije=new HashSet<>();

    @Override
    public String toString() {
        return "Sala{" +
                "oznaka='" + oznaka + '\'' +
                ", kapacitet=" + kapacitet +
                '}';
    }
}
