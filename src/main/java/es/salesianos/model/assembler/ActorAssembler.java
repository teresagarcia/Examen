package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;

public class ActorAssembler {

	public static Actor assembleActorFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String name = req.getParameter("name");
		String birthYear = req.getParameter("year");
		actor.setName(name);
		actor.setBirthYear(Integer.parseInt(birthYear));
		return actor;
	}

}
