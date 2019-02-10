package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;

public interface IActorService {

	List<Actor> listAllActor();

	void insert(Actor actor);

	void delete(int code);

	Actor findByCod(int code);

	List<Actor> filterActor(int startYear, int endYear);

}
