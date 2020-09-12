package Bioskop.repo;

import Bioskop.entity.Bioskop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BioskopRepo extends JpaRepository<Bioskop,Long> {

}
