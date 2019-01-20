package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Director;
import es.salesianos.service.DirectorService;

public class SearchDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DirectorService service = new DirectorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String name = req.getParameter("name");
		if (name != null) {
			List<Director> listFilterDirector = service.filterDirector(name);
			req.setAttribute("listFilterDirector", listFilterDirector);
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchDirector.jsp");
		dispatcher.forward(req, resp);
	}
}
