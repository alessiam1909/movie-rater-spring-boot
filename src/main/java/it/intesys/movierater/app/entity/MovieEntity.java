package it.intesys.movierater.app.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
@Table(name = "movie")
public class MovieEntity {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "actors")
    private String actors;

    @Column(name = "country")
    private String country;

    @Column(name = "total_votes")
    private Integer total_votes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(Integer total_votes) {
        this.total_votes = total_votes;
    }
}
