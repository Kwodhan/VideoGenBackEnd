package controller;

import generator.Generator;
import generator.VideoGenHelper;
import model.Acteur;
import model.ExtraitFilm;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import service.ActeurService;
import service.ExtraitFilmService;
import service.FilmService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/generator")
public class GeneratorController {
    @Autowired
    FilmService filmService;

    @Autowired
    ActeurService acteurService;

    @Autowired
    ExtraitFilmService extraitFilmService;



    @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
    public StreamingResponseBody getSteamingFile(@RequestParam("acteur") long idActeur,
                                                 @RequestParam("film") long idFilm, HttpServletResponse response) throws IOException {
        response.setContentType("video/mp4");
        response.setHeader("Content-Disposition", "attachment; filename=\"pirates2a.mp4\"");
        Acteur acteur = acteurService.findById(idActeur);
        Film film = filmService.findById(idFilm);
        String path = extraitFilmService.getExtraitFilmsByNameAndActor(film,acteur).iterator().next().getLocation();
        InputStream inputStream = new FileInputStream(new File("/home/aferey/IdeaProjects/server"+path));
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public StreamingResponseBody getFileGenerator(HttpServletResponse response,
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

        // Intro
        videoGen += addIntro(acteur);

        // question 1
        videoGen +=  addQuestion(film1,acteur);

        // answer
        videoGen +=  addAnswer(film1,acteur);

        // question 2
        videoGen +=  addQuestion(film2,acteur);

        // answer
        videoGen +=  addAnswer(film2,acteur);

        // question 3
        videoGen +=  addQuestion(film3,acteur);

        // answer
        videoGen +=  addAnswer(film3,acteur);


        videoGen += "}\n";
        System.out.println(videoGen);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd_HHmmss_SSS");
        String location = "/home/aferey/VideoGen/"+sdf.format(date)+".videogen";
        writeFile(location,videoGen);
        VideoGeneratorModel video = new VideoGenHelper().loadVideoGenerator(location);
        Generator generetor = new Generator();

        if(generetor.hasError(video)){
            System.out.println("error");
            return null;
        }
        String locationVideo = "/home/aferey/VideoGen/"+sdf.format(date)+".mp4";
        generetor.generate(video,locationVideo);
        response.setContentType("video/mp4");
        response.setHeader("Content-Disposition", "attachment; filename=\"MyQuizz.mp4"+"\"");

        try {
            InputStream inputStream = new FileInputStream(new File(locationVideo));
            return outputStream -> {
                int nRead;
                byte[] data = new byte[1024];
                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {

                    outputStream.write(data, 0, nRead);
                }
            };
        } catch (FileNotFoundException e) {
            return null;
        }

    }

    private void writeFile(String name,String texte){


        try {
            System.out.println(name);
            File ff=new File(name);
            ff.createNewFile();
            FileWriter ffw=new FileWriter(ff);
            ffw.write(texte);
            ffw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private String addIntro(Acteur acteur) {
        String videoGen ="mandatory videoseq ";
        String id = acteur.getNom()+"_Intro ";
        videoGen += id;
        videoGen += "\"" +acteur.getLocationIntro()+"\"\n";

        return videoGen;

    }

    private String addAnswer(Film film,Acteur acteur) {
        String videoGen ="mandatory videoseq ";
        String id = film.getNom().replaceAll(" ","_") + acteur.getNom()+"_Answer ";
        videoGen += id;
        videoGen += "\""+film.getLocationAnswer()+"\"\n";

        return videoGen;

    }

    private String addQuestion( Film film,Acteur acteur) {
        String videoGen ="";
        Set<ExtraitFilm> extraitFilmSet = extraitFilmService.getExtraitFilmsByNameAndActor(film,acteur);
        String id = film.getNom().replaceAll(" ","_");
        videoGen += "alternatives "+ id + " {\n";
        for(ExtraitFilm extraitFilm : extraitFilmSet){
            videoGen += "\tvideoseq " + id+"_"+extraitFilm.getId() +" \""+ extraitFilm.getLocation()+"\"\n";

        }
        videoGen += "}\n";
        return  videoGen;
    }


}
