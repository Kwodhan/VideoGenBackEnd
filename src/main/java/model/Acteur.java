package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "ACTEUR")
public class Acteur {
    private Long id;
    private String prenom;
    private String nom;
    private String locationIntro;

    Set<Film> films = new HashSet<>();

    public Acteur() {
    }

    public String getLocationIntro() {
        return locationIntro;
    }

    public void setLocationIntro(String locationIntro) {
        this.locationIntro = locationIntro;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }




    @ManyToMany
    @JsonIgnore
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
