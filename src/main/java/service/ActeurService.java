package service;

import model.Acteur;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ActeurRepository;

import java.util.List;
import java.util.Set;

@Service
public class ActeurService {

    @Autowired
    private ActeurRepository acteurRepository;



    public ActeurService() {

    }

    public List<Acteur> findAll() {
        return this.acteurRepository.findAll();
    }

    public Acteur findById(Long id) {
        return this.acteurRepository.findOne(id);
    }

    public Set<Film> findFilmsByActeur(Long id){return this.acteurRepository.findFilmByActor(id);}
}
