package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Director;
import es.salesianos.model.assembler.DirectorAssembler;
import es.salesianos.repository.DirectorRepository;

@Service
public class DirectorService {
	
	@Autowired
	private DirectorRepository repository;
	
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
