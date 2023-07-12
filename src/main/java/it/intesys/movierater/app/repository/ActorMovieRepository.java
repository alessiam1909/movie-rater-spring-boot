package it.intesys.movierater.app.repository;

import it.intesys.movierater.app.entity.ActorMovieEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ActorMovieRepository {
    private final EntityManager em;

    public ActorMovieRepository(EntityManager em) {
        this.em = em;
    }

    public List<ActorMovieEntity> getActors(Integer actorId){
        return em.createQuery("FROM ActorMovieEntity where actor.id = :actorId", ActorMovieEntity.class)
                .setParameter("actorId",actorId)
                .getResultList();
    }

    public List<ActorMovieEntity> getMovies(Integer movieId){
        return em.createQuery("FROM ActorMovieEntity where movie.id = :movieId", ActorMovieEntity.class)
                .setParameter("movieId",movieId)
                .getResultList();
    }

    public void insertMovieActor(ActorMovieEntity actorMovieEntity) {
        em.persist(actorMovieEntity);
    }
}
