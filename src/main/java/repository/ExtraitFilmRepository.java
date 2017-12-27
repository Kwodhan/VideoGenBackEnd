package repository;

import model.Acteur;
import model.ExtraitFilm;
import model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ExtraitFilmRepository  extends JpaRepository<ExtraitFilm, Long>  {


    @Query("select distinct e from ExtraitFilm e where e.film = :film and e.acteur = :acteur")
    Set<ExtraitFilm> findExtraitFilmByName(@Param("film") Film film, @Param("acteur") Acteur acteur);
}
