package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

public class RecoveryFilmServlet extends ActorServlet {

	private static final long serialVersionUID = 1L;
	private ActorService actorService = new ActorService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cod = req.getParameter("codFilm");
		req.setAttribute("codFilm", cod);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Actor> listAllActor = actorService.listAllActor();
		req.setAttribute("listAllActor", listAllActor);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/chooseActor.jsp");
		dispatcher.forward(req, resp);
	}
}
