package service;

import model.Acteur;
import model.ExtraitFilm;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ExtraitFilmRepository;

import java.util.Set;

@Service
public class ExtraitFilmService {

    @Autowired
    private ExtraitFilmRepository extraitFilmRepository;



    public ExtraitFilmService() {

    }



    public Set<ExtraitFilm> getExtraitFilmsByNameAndActor(Film film, Acteur acteur) {
        return this.extraitFilmRepository.findExtraitFilmByName(film,acteur);
    }
}
