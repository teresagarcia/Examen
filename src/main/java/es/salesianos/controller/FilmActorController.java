package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.service.ActorService;
import es.salesianos.service.FilmService;

@Controller
public class FilmActorController  {

	@Autowired
	FilmService filmService;
	@Autowired
	ActorService actorService;

	@GetMapping("/linkActors")
	protected ModelAndView getFilmsToLink() {
		List<Film> listAllFilm = filmService.selectAllFilm();
		ModelAndView model = new ModelAndView("linkActors");
		model.addObject("listAllFilm", listAllFilm);
		return model;
	}

	@GetMapping("/chooseActor")
	protected ModelAndView chooseActor(@RequestParam Integer filmCod) {
		List<Actor> listAllActor = actorService.listAllActor();
		ModelAndView model = new ModelAndView("chooseActor");
		model.addObject("listAllActor", listAllActor);
		model.addObject("filmCod", filmCod);
		return model;
	}

	@GetMapping("/fillFilmActor")
	protected ModelAndView fillFilmActor(@RequestParam Integer filmCod, @RequestParam Integer actorCod) {
		return null;
	}
}
