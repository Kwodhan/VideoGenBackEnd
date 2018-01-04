package controller;

import model.Acteur;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ActeurService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/acteurs")
public class ActeurRestController {
    @Autowired
    ActeurService acteurService;



    @RequestMapping(value = "", method = RequestMethod.GET )
    public ResponseEntity<List<Acteur>>  getActeurs() {
        List<Acteur> l1;

        l1 = this.acteurService.findAll();

        return new ResponseEntity<>(l1, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<Set<Film>>  getFilmsByActeur(@PathVariable("id") long id) {
        Set<Film> l1;

        l1 = this.acteurService.findFilmsByActeur(id);

        return new ResponseEntity<>(l1, HttpStatus.OK);

    }
}
