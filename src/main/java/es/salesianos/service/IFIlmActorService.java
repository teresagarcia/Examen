package es.salesianos.service;

import es.salesianos.model.ActorFilmDTO;
import es.salesianos.model.FilmActor;

public interface IFIlmActorService {

	void insert(FilmActor filmActor);

	ActorFilmDTO filterActorFilm(String role);

}
