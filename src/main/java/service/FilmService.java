package service;

import model.Acteur;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ExtraitFilmRepository;
import repository.FilmRepository;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAll() {
        return this.filmRepository.findAll();
    }

    public Film findById(Long id) {
        return this.filmRepository.findOne(id);
    }
}
