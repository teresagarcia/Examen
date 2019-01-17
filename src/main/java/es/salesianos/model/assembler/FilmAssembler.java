package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Film;

public class FilmAssembler {

	public static Film assembleFilmFrom(HttpServletRequest req) {
		Film film = new Film();
		String title = req.getParameter("title");
		String codDirector = req.getParameter("codDirector");
		film.setTitle(title);
		film.setCodDirector(Integer.parseInt(codDirector));
		return film;
	}
}
