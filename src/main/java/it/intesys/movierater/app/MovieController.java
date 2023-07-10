package it.intesys.movierater.app;

import org.javatuples.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> get2RandomMovies()

    {
        List<Movie> randomMovies = movieService.get2RandomMovies();
        return ResponseEntity.ok(randomMovies);
    }

    @ModelAttribute(name="movieCount")
    public Long movieCount() {
        return movieService.getMovieCount();
    }

    @PostMapping("/vote")
    public String submitVote(@ModelAttribute Movie movie) {
        movieService.vote(movie.getId());
        return "redirect:/";
    }

    @GetMapping("/movie/{movieId}")
    public String getMovieDetails(@PathVariable("movieId") Long movieId) {
        return "movie";
    }
}
