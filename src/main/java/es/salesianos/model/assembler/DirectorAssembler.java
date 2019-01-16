package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Director;

public class DirectorAssembler {

	public static Director assembleDirectorFrom(HttpServletRequest req) {
		Director director = new Director();
		String name = req.getParameter("name");
		director.setName(name);
		return director;
	}
}
