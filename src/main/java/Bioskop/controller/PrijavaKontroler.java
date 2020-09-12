package Bioskop.controller;


import Bioskop.dto.KorisnikDTO;
import Bioskop.dto.PrijavaDTO;
import Bioskop.entity.Korisnik;
import Bioskop.service.PrijavaServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/api")
public class PrijavaKontroler {
    private final PrijavaServis prijavaServis;

    @Autowired
    public PrijavaKontroler(PrijavaServis prijavaServis) {
        this.prijavaServis = prijavaServis;
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain")
    public ResponseEntity<String> prijava(@RequestBody PrijavaDTO prijavaDTO) throws Exception {
        Korisnik korisnik = this.prijavaServis.prijava(prijavaDTO.korIme, prijavaDTO.lozinka);

        if(korisnik == null)
            return new ResponseEntity<>("PROBLEM", HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(korisnik.getUloga(), HttpStatus.OK);
    }

    @GetMapping(path = "/logout")
    public void odjava() {
        this.prijavaServis.odjava();
    }

    @GetMapping(path = "/prijavljen", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> prijavljenKorisnik() {
        Korisnik model = this.prijavaServis.getPrijavljen();

        KorisnikDTO DTO = new KorisnikDTO();
        DTO.korIme = model.getKorIme();
        DTO.lozinka = model.getLozinka();
        DTO.ime = model.getIme();
        DTO.prezime = model.getPrezime();
        DTO.brTel = model.getBrojTel();
        DTO.mail = model.getMail();
        DTO.datumrodj= model.getDatumrodj();
        DTO.uloga = model.getUloga();



        return new ResponseEntity<>(DTO, HttpStatus.OK);
    }


}
