package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.service.ActorService;
import es.salesianos.service.DirectorService;
import es.salesianos.service.Service;
import es.salesianos.service.Service;

public class DirectorServlet extends HttpServlet {

	private DirectorService service = new DirectorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Director director = service.assembleDirectorFromRequest(req);
		service.insert(director);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/director.jsp");
		dispatcher.forward(req, resp);
	}
	
}
