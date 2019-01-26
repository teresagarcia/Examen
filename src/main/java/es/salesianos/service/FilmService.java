package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository repository;

	public Film assembleFilmFromRequest(HttpServletRequest req) {
		return FilmAssembler.assembleFilmFrom(req);
	}

	public List<Film> selectAllFilm() {
		return repository.selectAllFilm();
	}

	public void insert(Film film) {
		repository.insert(film);
	}

	public void delete(int code) {
		repository.delete(code);
	}

}
