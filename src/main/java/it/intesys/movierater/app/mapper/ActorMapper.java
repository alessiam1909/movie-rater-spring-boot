package it.intesys.movierater.app.mapper;

import it.intesys.movierater.app.dto.Actor;
import it.intesys.movierater.app.entity.ActorEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActorMapper {
    public Actor toDTO(ActorEntity actorEntity){
        Actor actor = new Actor();
        actor.setId(actorEntity.getId());
        actor.setName(actorEntity.getName());
        return actor;
    }

    public ActorEntity toEntity(ActorEntity actor){
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setId(actor.getId());
        actorEntity.setName(actor.getName());
        return actorEntity;
    }

    public List<ActorEntity> toEntityList(List<ActorEntity> actorsDTO){
        List<ActorEntity> actors = new ArrayList<>();
        for (ActorEntity actor: actorsDTO
        ) {
            actors.add(toEntity(actor));
        }
        return actors;
    }

    public List<Actor> toDTOList(List<ActorEntity> actorsEntity){
        List<Actor> actors = new ArrayList<>();
        for (ActorEntity actor: actorsEntity
        ) {
            actors.add(toDTO(actor));
        }
        return actors;
    }
}
