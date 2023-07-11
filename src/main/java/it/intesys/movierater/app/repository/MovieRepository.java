package it.intesys.movierater.app.repository;

import it.intesys.movierater.app.entity.MovieEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class MovieRepository {

    private final EntityManager em;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate, EntityManager em) {
        this.jdbcTemplate = jdbcTemplate;
        this.em= em;
    }

    //prima task test, creo una funzione che mi restituisca una lista di movies, attraverso una query al database
    public List<MovieEntity> getMovies() {

        List<MovieEntity> movies = em.createQuery("from MovieEntity ", MovieEntity.class)
                .getResultList();

        return movies;
    }

    //creo una funzione che mi restituisca un film attraverso il suo id
    public MovieEntity getMovieById(Integer movieId){
        return em.find(MovieEntity.class, movieId);

    }

    //creo una funzione che aggiorni i voti dei film
    public void updateVotes(MovieEntity movie){
        em.merge(movie);
    }

}

