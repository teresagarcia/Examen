package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.repository.FilmRepository;

public class FilmService {

	private FilmRepository repository = new FilmRepository();

	public Film assembleFilmFromRequest(HttpServletRequest req) {
		return FilmAssembler.assembleFilmFrom(req);
	}

	public List<Film> selectAllFilm() {
		return repository.selectAllFilm();
	}

	public void insert(Film film) {
		repository.insert(film);
	}

	public void delete(Film film) {
		repository.delete(film);
	}

}
