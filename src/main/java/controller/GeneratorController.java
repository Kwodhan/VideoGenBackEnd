package controller;

import model.Acteur;
import model.ExtraitFilm;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ActeurService;
import service.ExtraitFilmService;
import service.FilmService;

import java.util.Set;

@RestController
@RequestMapping(value = "/generator")
public class GeneratorController {
    @Autowired
    FilmService filmService;

    @Autowired
    ActeurService acteurService;

    @Autowired
    ExtraitFilmService extraitFilmService;


    @RequestMapping(value = "/request", method = RequestMethod.GET)
    @ResponseBody
    public String getFileGenerator(
            @RequestParam("acteur") long idActeur,
            @RequestParam("film1") long idFilm1,
            @RequestParam("film2") long idFilm2,
            @RequestParam("film3") long idFilm3) {
        Acteur acteur = acteurService.findById(idActeur);

        Film film1 = filmService.findById(idFilm1);
        if( !(film1 != null && film1.getActeurs().contains(acteur))){
           return null;
        }

        Film film2 = filmService.findById(idFilm2);
        if(!(film2 != null && film2.getActeurs().contains(acteur))){
            return null;
        }

        Film film3 = filmService.findById(idFilm3);
        if(!(film3 != null && film3.getActeurs().contains(acteur))){
            return null;
        }
        String videoGen = "VideoGen { \n";

        videoGen +=  addAlternative(film1,acteur);

        videoGen +=  addAlternative(film2,acteur);

        videoGen +=  addAlternative(film3,acteur);

        videoGen += "}\n";
        return videoGen;
    }

    private String addMandatory(String videoGen) {
        return "";
    }

    private String addAlternative( Film film,Acteur acteur) {
        String videoGen ="";
        Set<ExtraitFilm> extraitFilmSet = extraitFilmService.getExtraitFilmsByNameAndActor(film,acteur);
        String id = film.getNom().replaceAll(" ","_");
        videoGen += "\talternatives "+ id + " {\n";
        for(ExtraitFilm extraitFilm : extraitFilmSet){
            videoGen += "\t\tvideoseq " + id+extraitFilm.getId() +" \""+ extraitFilm.getLocation()+"\"\n";

        }
        videoGen += "\t}\n";
        return  videoGen;
    }

    private String addOptionnal(String videoGen) {
        return "";
    }
}
