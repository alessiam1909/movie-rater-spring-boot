package it.intesys.movierater.app.service;

import it.intesys.movierater.app.dto.Actor;
import it.intesys.movierater.app.entity.ActorEntity;
import it.intesys.movierater.app.mapper.ActorMapper;
import it.intesys.movierater.app.repository.ActorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActorService {

    private final ActorRepository actorRepository;

    private final ActorMapper actorMapper;

    public ActorService(ActorRepository actorRepository, ActorMapper actorMapper) {
        this.actorRepository = actorRepository;
        this.actorMapper = actorMapper;
    }

    public Actor getActorById(Integer actorId){
        return actorMapper.toDTO(actorRepository.getActorById(actorId));
    }

    public Actor getActorByName(String name){
        return actorMapper.toDTO(actorRepository.getActorByName(name));
    }

    public List<Actor> getActors(){
        return actorMapper.toDTOList(actorRepository.getActors());
    }



    public void postActorEntity(ActorEntity actorEntity){
        actorRepository.insertActor(actorEntity);
    }

}
