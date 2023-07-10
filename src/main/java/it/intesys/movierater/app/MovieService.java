package it.intesys.movierater.app;

import it.intesys.movierater.app.repository.MovieRepository;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Pair<Movie, Movie> get2RandomMovies() {
        return Pair.with(
                new Movie(1L,"Pulp Fiction", "Quentin Tarantino"),
                new Movie(2L, "Titanic", "James Cameron"));
    }

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
