package it.intesys.movierater.app;

import it.intesys.movierater.app.repository.MovieRepository;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> get2RandomMovies() {
        List<Movie> allMovies = movieRepository.getMovies();

        // Genera due numeri casuali tra 0 e la dimensione della lista dei film
        Random random = new Random();
        int index1 = random.nextInt(allMovies.size());
        int index2 = random.nextInt(allMovies.size());

        // cerco un numero nuovo se i due numeri sono uguali finchè non ne trovo due diversi
        while (index2 == index1) {
            index2 = random.nextInt(allMovies.size());
        }

        // Recupero i due film random
        Movie movie1 = allMovies.get(index1);
        Movie movie2 = allMovies.get(index2);

        // Crea una lista che li contenga
        List<Movie> randomMovies = new ArrayList<>();
        randomMovies.add(movie1);
        randomMovies.add(movie2);

        return randomMovies;
    }

    // Richiamo la repository dove ho creato la funzione per restituire la lista di movies e attraverso una funzione ritorno il numero totale di film nel database
    public List<Movie> getMovies(){
        return movieRepository.getMovies();
    }

    public Long getMovieCount(){
        return getMovies().stream().count();
    }

    public void vote(Long movieId) {
        logger.info("Add vote for movie {}", movieId);
    }
}
