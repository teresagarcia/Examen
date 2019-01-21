package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

public class ActorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ActorService service = new ActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor actor = service.assembleActorFromRequest(req);
		service.insert(actor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("cod");
		if (code != null) {
			service.delete(Integer.parseInt(code));
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String startDateString = req.getParameter("startYear");
		if (startDateString != null) {
			int startDate = Integer.parseInt(startDateString);
			int endDate = Integer.parseInt(req.getParameter("endYear"));
			List<Actor> filteredActors = service.filterActor(startDate, endDate);
			req.setAttribute("listAllActor", filteredActors);
		} else {
			List<Actor> listAllActor = service.listAllActor();
			req.setAttribute("listAllActor", listAllActor);
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actor.jsp");
		dispatcher.forward(req, resp);
	}
}
