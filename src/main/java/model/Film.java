package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FILM")
public class Film {

    private Long id;

    private String nom;

    private String locationAnswer;

    Set<ExtraitFilm> extraitFilms = new HashSet<>();

    Set<Acteur> acteurs = new HashSet<>();

    public String getLocationAnswer() {
        return locationAnswer;
    }

    public void setLocationAnswer(String locationAnswer) {
        this.locationAnswer = locationAnswer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    @OneToMany
    @JsonIgnore
    public Set<ExtraitFilm> getExtraitFilms() {
        return extraitFilms;
    }

    public void setExtraitFilms(Set<ExtraitFilm> extraitFilms) {
        this.extraitFilms = extraitFilms;
    }

    @ManyToMany(mappedBy = "films")
    @JsonIgnore
    public Set<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }
}
