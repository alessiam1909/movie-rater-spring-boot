package it.intesys.movierater.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "actor_movie")
public class ActorMovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @OneToOne
    @JoinColumn(name = "actor_id")
    private ActorEntity actor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public ActorEntity getActor() {
        return actor;
    }

    public void setActor(ActorEntity actor) {
        this.actor = actor;
    }
}
