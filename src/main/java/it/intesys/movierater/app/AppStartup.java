package it.intesys.movierater.app;

import it.intesys.movierater.app.dto.Actor;
import it.intesys.movierater.app.dto.Movie;
import it.intesys.movierater.app.entity.ActorEntity;
import it.intesys.movierater.app.entity.ActorMovieEntity;
import it.intesys.movierater.app.mapper.ActorMapper;
import it.intesys.movierater.app.mapper.MovieMapper;
import it.intesys.movierater.app.service.ActorMovieService;
import it.intesys.movierater.app.service.ActorService;
import it.intesys.movierater.app.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class AppStartup {
    private final ActorService actorService;

    private final MovieService movieService;

    private final MovieMapper movieMapper;

    private final EntityManager em;

    private final ActorMapper actorMapper;

    private final ActorMovieService actorMovieService;



    public AppStartup(ActorService actorService, MovieService movieService, MovieMapper movieMapper, ActorMapper actorMapper, ActorMovieService actorMovieService, EntityManager em) {
        this.actorService = actorService;
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.actorMapper = actorMapper;
        this.em = em;
        this.actorMovieService = actorMovieService;
    }

    private final Logger log = LoggerFactory.getLogger(AppStartup.class);


    public HashMap<String, List<Integer>> getAttoriwithFilm(List<Movie> movies){
        //creo una mappa di attori con film
        HashMap<String, List<Integer>> attori= new HashMap<>();
        //per ogni film divido la stringa degli attori
        for (Movie movie: movies) {
            String[] attoriMovie = movie.getActors().split(", ");

            //Per ogni attore vedo se è presente o no nel database altrimenti aggiungo solo l'id del film
            for (String attore: attoriMovie) {
                if(attori.containsKey(attore)){
                    List<Integer> film = attori.get(attore);
                    film.add(movie.getId().intValue());
                    attori.replace(attore, film);
                }else{
                    List<Integer> addActor = new ArrayList<>();
                    addActor.add(movie.getId().intValue());
                    attori.put(attore, addActor);
                }
            }
        }
        return attori;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void setActors() {
        if(actorService.getActors().isEmpty()){
            //se la lista è vuota inserisco gli attori
            HashMap<String, List<Integer>> attori = getAttoriwithFilm(movieService.getMovies());
            for (String attore: attori.keySet()){
                log.info(attore);
                ActorEntity newAttore = prepareActor(attore);
                actorService.postActorEntity(newAttore);
                for(Integer id: attori.get(attore)){
                    ActorMovieEntity actorMovie = new ActorMovieEntity();
                    actorMovie.setMovie(movieMapper.toEntity(movieService.getMovieById(id)));
                    actorMovie.setActor(actorMapper.toEntity(newAttore));
                    em.persist(actorMovie);
                }
            }

        }
    }


    public ActorEntity prepareActor(String name){
        ActorEntity newAttore = new ActorEntity();
        newAttore.setName(name);
        return newAttore;
    }
}
