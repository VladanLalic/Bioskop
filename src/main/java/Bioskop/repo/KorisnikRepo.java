package Bioskop.repo;

import Bioskop.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepo extends JpaRepository<Korisnik,Long> {
}
