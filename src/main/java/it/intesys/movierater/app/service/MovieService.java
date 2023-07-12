package it.intesys.movierater.app.service;

import it.intesys.movierater.app.dto.Movie;
import it.intesys.movierater.app.entity.MovieEntity;
import it.intesys.movierater.app.mapper.MovieMapper;
import it.intesys.movierater.app.repository.MovieRepository;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    private final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;

    }

    public Pair<MovieEntity, MovieEntity> get2RandomMovies() {
        Integer movieCount = getMovieCount().intValue();

        // Genera due numeri casuali tra 0 e la dimensione della lista dei film
        Random random = new Random();
        Integer index1 = random.nextInt(movieCount);
        Integer  index2 = random.nextInt(movieCount);

        // cerco un numero nuovo se i due numeri sono uguali finchè non ne trovo due diversi
        while (index2 == index1) {
            index2 = random.nextInt(movieCount);
        }

        // Recupero i due film random
        MovieEntity movie1 = movieRepository.getMovieById(index1);
        MovieEntity movie2 = movieRepository.getMovieById(index2);


        return Pair.with(movie1, movie2);
    }

    // Richiamo la repository dove ho creato la funzione per restituire la lista di movies e attraverso una funzione ritorno il numero totale di film nel database
    public List<Movie> getMovies(){
        return movieMapper.toDTOList(movieRepository.getMovies());
    }

    public Long getMovieCount(){
        return getMovies().stream().count();
    }


    public Integer getMovieVoteById(Integer movieId){
        return movieRepository.getMovieById(movieId).getTotal_votes();
    }

    public void vote(int movieId) {
        MovieEntity movie = movieRepository.getMovieById((movieId));
        int newVote = getMovieVoteById((movieId)) + 1;
        movie.setTotal_votes(newVote);
        movieRepository.updateVotes(movie);
    }

   //recupero un singolo film per id
    public Movie getMovieById(Integer movieId){
        return movieMapper.toDTO(movieRepository.getMovieById(movieId));
    }


    public Long getVotes(){
        List<MovieEntity> movies = movieRepository.getMovies();
        Integer votes = 0;
        for (MovieEntity movie: movies) {
            votes = votes + movie.getTotal_votes();
        }
        return (long)votes;
    }
}
