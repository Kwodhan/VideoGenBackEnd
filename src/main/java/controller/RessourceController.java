package controller;

import model.Film;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.FilmService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/ressource")
public class RessourceController {

    @Autowired
    FilmService filmService;

    @RequestMapping(value = "/images/{id}", method = RequestMethod.GET)
    public void getImageAsByteArray(@PathVariable("id") long id,HttpServletResponse response) throws IOException {
        Film film = filmService.findById(id);
        if(film == null){
            return;
        }
        InputStream in = new FileInputStream(new File(film.getLocationImage().replaceFirst("^~",System.getProperty("user.home"))));
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


}
