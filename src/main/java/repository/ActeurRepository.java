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
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    @Query("select distinct e.films from Acteur e where e.id = :id")
    Set<Film> findFilmByActor( @Param("id") Long id);
}
