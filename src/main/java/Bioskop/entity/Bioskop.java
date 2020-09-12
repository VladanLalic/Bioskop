package Bioskop.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bioskop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private Long brojtel ;

    @Column
    private Email mail;

    @Column
    private String menadzer;



    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(String menadzer) {
        this.menadzer = menadzer;
    }

    public Email getMail () { return mail;}

    public void setMail(Email mail) {
        this.mail = mail;
    }

    public Long getBrojtel () {return  brojtel;}

    public void setBrojtel(Long brojtel) {
        this.brojtel = brojtel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<Korisnik> getMenadzeri() {
        return menadzeri;
    }

    public void setMenadzeri(Set<Korisnik> menadzeri) {
        this.menadzeri = menadzeri;
    }

    @OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sala> sale= new HashSet<>();



    @ManyToMany
    @JoinTable  (name = "menadzer",
            joinColumns = @JoinColumn(name = "Bioskop_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "menadzer_id", referencedColumnName = "id"))
    private  Set<Korisnik> menadzeri = new HashSet<>();



    @Override
    public String toString() {
        return "Bioskop{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojtel=" + brojtel +
                ", mail=" + mail +
                ", menadzer='" + menadzer + '\'' +
                ", sale=" + sale +
                '}';
    }
}
