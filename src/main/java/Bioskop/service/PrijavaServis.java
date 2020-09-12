package Bioskop.service;

import Bioskop.entity.Korisnik;
import Bioskop.repo.KorisnikRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PrijavaServis {
    @Autowired
    private KorisnikRepo korisnikRepo;

    private Korisnik prijavljen = null;

    public Korisnik getPrijavljen() {
        return prijavljen;
    }

    public void setPrijavljen(Korisnik prijavljen) {
        this.prijavljen = prijavljen;
    }


    public Korisnik prijava(String korIme, String lozinka){
        List<Korisnik> korisnici = this.korisnikRepo.findAll();
        for(Korisnik kor : korisnici) {
            if(kor.getKorIme().equals(korIme)){
                if(kor.getLozinka().equals(lozinka)) {
                    prijavljen = kor;
                    return kor;
                }
                return null;
            }
        }

        return null;
    }

    public void odjava() {
        prijavljen = null;
    }
}
