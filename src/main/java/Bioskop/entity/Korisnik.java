package Bioskop.entity;


import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true,nullable = false)
    private String korIme;

    @Column(nullable = false)
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(name="brojTelefona")
    private Long brTel;

    @Column
    private Email mail;

    @Column
    private BaseCalendar.Date datumrodj;

    @Column
    private String uloga;

    public Long getBrTel() {
        return brTel;
    }

    public void setBrTel(Long brTel) {
        this.brTel = brTel;
    }

    @Column
    private Boolean aktivan;

    public String getKorIme() {
        return korIme;
    }

    public String getIme() {
        return ime;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public Long getBrojTel() {
        return brTel;
    }

    public void setMail(Email mail) {
        this.mail = mail;
    }

    public BaseCalendar.Date getDatumrodj() {
        return datumrodj;
    }

    public Email getMail() {
        return mail;
    }


    public String getLozinka() {
        return lozinka;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getUloga() {
        return uloga;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public void setBrojTel(Long brojTel) {
        this.brTel = brojTel;
    }

    public void setDatumrodj(BaseCalendar.Date datumrodj) {
        this.datumrodj = datumrodj;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }


    @ManyToMany
    @JoinTable  (name = "rezervisano",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
    private Set<Projekcija> rezervisanaProjekcija = new HashSet<>();

    @OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <PogledaniFilmovi> pogledaniFilmovi = new HashSet<>();


    public Set<Projekcija> getRezervisanaProjekcija() {
        return rezervisanaProjekcija;
    }

    public void setRezervisanaProjekcija(Set<Projekcija> rezervisanaProjekcija) {
        this.rezervisanaProjekcija = rezervisanaProjekcija;
    }

    public Set<PogledaniFilmovi> getPogledaniFilmovi() {
        return pogledaniFilmovi;
    }

    public void setPogledaniFilmovi(Set<PogledaniFilmovi> pogledaniFilmovi) {
        this.pogledaniFilmovi = pogledaniFilmovi;
    }

    public Set<Bioskop> getMenadzerBioskopa() {
        return menadzerBioskopa;
    }

    public void setMenadzerBioskopa(Set<Bioskop> menadzerBioskopa) {
        this.menadzerBioskopa = menadzerBioskopa;
    }

    @ManyToMany (mappedBy = "menadzeri", fetch = FetchType.LAZY)
    private  Set<Bioskop> menadzerBioskopa = new HashSet<>();



    @Override
    public String toString() {
        return "Korisnik{" +
                "korIme='" + korIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojTel=" + brTel +
                ", mail=" + mail +
                ", datumrodj=" + datumrodj +
                ", uloga=" + uloga +
                ", aktivan=" + aktivan +
                '}';
    }
}
