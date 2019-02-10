package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Film;

public interface IFilmService {

	List<Film> selectAllFilm();

	void insert(Film film);

	void delete(int code);
}
