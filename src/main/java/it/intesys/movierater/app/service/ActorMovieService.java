package it.intesys.movierater.app.service;

import it.intesys.movierater.app.dto.Actor;
import it.intesys.movierater.app.entity.ActorMovieEntity;
import it.intesys.movierater.app.repository.ActorMovieRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActorMovieService {
    private final ActorMovieRepository actorMovieRepository;

    public ActorMovieService(ActorMovieRepository actorMovieRepository) {
        this.actorMovieRepository = actorMovieRepository;
    }


    public void insertMovieActor(ActorMovieEntity actorMovieEntity){
        actorMovieRepository.insertMovieActor(actorMovieEntity);
    }

    public List<Integer> getActorforMovie(Integer actorId){
        return new ArrayList<>();
    }

    public void postActorMovieEntity(ActorMovieEntity actorMovie) {
    }
}
