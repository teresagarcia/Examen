package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Director;

public interface IDirectorService {

	List<Director> listAllDirector();

	void insert(Director director);

	void delete(int code);

	List<Director> filterDirector(String name);

}
