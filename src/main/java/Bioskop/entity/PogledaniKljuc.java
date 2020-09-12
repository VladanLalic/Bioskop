package Bioskop.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class PogledaniKljuc implements  Serializable{


    private static final long serialVersionUID = 1L;

    @Column(name = "korisnik_id")
    private Long korisnikID;

    @Column (name = "film_id")
    private Long filmID;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof PogledaniKljuc)) {
            return false;
        }
        PogledaniKljuc key = (PogledaniKljuc) obj;
        return korisnikID == key.korisnikID &&
                filmID == key.filmID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnikID, filmID);
    }

    public Long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Long userId) {
        this.korisnikID = korisnikID;
    }

    public Long getFilmID() {
        return filmID;
    }

    public void setFilmID(Long filmID) {
        this.filmID = filmID;
    }
}
