package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Director;
import es.salesianos.model.assembler.DirectorAssembler;
import es.salesianos.repository.DirectorRepository;

public class DirectorService {
	
	private DirectorRepository repository = new DirectorRepository();
	
	public Director assembleDirectorFromRequest(HttpServletRequest req) {
		return DirectorAssembler.assembleDirectorFrom(req);
	}
	
	public List<Director> listAllDirector() {
		return repository.listAllDirector();
	}
	
	public void insert(Director director) {
		repository.insert(director);
	}
	
	public void delete(int code) {
		repository.delete(code);
	}

	public List<Director> filterDirector(String name) {
		return repository.filterDirector(name);
	}

}
