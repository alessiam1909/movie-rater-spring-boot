package it.intesys.movierater.app.dto;

public class Movie {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String director;
    private String actors;
    private String country;
    private Integer total_votes;

    public Movie() {
    }

    public Movie(Long id, String title, Integer year, String genre, String director, String actors, String country, Integer total_votes) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.country = country;
        this.total_votes = total_votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(Integer total_votes) {
        this.total_votes = total_votes;
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
}
