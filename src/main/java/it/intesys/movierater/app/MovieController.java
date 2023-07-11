package it.intesys.movierater.app;

import it.intesys.movierater.app.dto.Movie;
import it.intesys.movierater.app.entity.MovieEntity;
import org.javatuples.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class  MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    //fixed Pair instead of list to show movies on screen
    @GetMapping("/")
    public  String index(Model model){
        Pair<MovieEntity, MovieEntity> randomMovies = movieService.get2RandomMovies();
        model.addAttribute("movie1", randomMovies.getValue0());
        model.addAttribute("movie2", randomMovies.getValue1());
        return "index";
    }

    @ModelAttribute(name="movieCount")
    public Long movieCount() {
        return movieService.getMovieCount();
    }

    @ModelAttribute(name="voteCount")
    public Long voteCount() {
        return movieService.getVotes();
    }

    @PostMapping("/vote")
    public String submitVote(@ModelAttribute Movie movie) {
        movieService.vote(movie.getId().intValue());
        return "redirect:/";
    }

    @GetMapping("/movie/{movieId}")
    public String getMovieDetails(@PathVariable("movieId") Long movieId) {
        return "movie";
    }
}
