package Bioskop.repo;

import Bioskop.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepo extends JpaRepository<Sala,Long> {
}
