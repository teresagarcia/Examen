package es.salesianos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.ActorFilmDTO;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

@Service
public class FilmActorService {

	@Autowired
	FilmActorRepository repository;

	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}

	public ActorFilmDTO filterActorFilm(String role) {
		return repository.filterActorFilm(role);
	}

}
