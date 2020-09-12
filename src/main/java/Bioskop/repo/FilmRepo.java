package Bioskop.repo;

import Bioskop.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film,Long> {
}
