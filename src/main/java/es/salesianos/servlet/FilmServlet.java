package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.service.Service;
import es.salesianos.service.Service;

public class FilmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");
		String title = req.getParameter("title");
		String codDirectorString = req.getParameter("codDirector");
		Film film = new Film();
		int cod = Integer.parseInt(codString);
		film.setCod(cod);
		int codDirector = Integer.parseInt(codDirectorString);
		film.setCodDirector(codDirector);
		film.setTitle(title);
		service.insert(film);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");
		
		if(null != codString) {
			Film film = new Film();
			int cod = Integer.parseInt(codString);
			film.setCod(cod);
			service.delete(film);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Film> selectAllFilm = service.selectAllFilm();
		req.setAttribute("listAllFilm", selectAllFilm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/film.jsp");
		dispatcher.forward(req, resp);
	}
	
}
