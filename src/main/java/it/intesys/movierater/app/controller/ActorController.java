package it.intesys.movierater.app.controller;

import it.intesys.movierater.app.service.ActorService;
import it.intesys.movierater.app.service.MovieService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

@Controller
public class ActorController {

    private final ActorService actorService;

    private final MovieService movieService;

    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping("/actor/{actorId}")
    public String getMovieDetails(Model model, @PathVariable("actorId") int actorId) {
        model.addAttribute("actor", actorService.getActorById((actorId)));
        model.addAttribute("movies",movieService.get2RandomMovies());
        return "actor";
    }
}
