package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Director;
import es.salesianos.repository.DirectorRepository;

public class DirectorService {
	
	private DirectorRepository repository = new DirectorRepository();
	
	public List<Director> selectAllDirector() {
		return repository.selectAllDirector();
	}
	
	public void insert(Director director) {
		repository.insert(director);
	}
	
	public void delete(Director director) {
		repository.delete(director);
	}

}
