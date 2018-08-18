package com.skilldistillery.springmvcfilmcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.springmvcfilmcrud.database.FilmDAO;
import com.skilldistillery.springmvcfilmcrud.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO dao;

	public void setFilmDAO(FilmDAO dao) {
		this.dao = dao;
	}

	public FilmDAO getDao() {
		return dao;
	}

	// This method will use the action "searchFilmById.do" via
	// ./WebContent/searchFilmById.html
	// The method will use FilmDAOImpl to access sdvid schema and retrieve a film
	// corresponding to the filmId input parameter the user inputs to the form
	@RequestMapping(path = "searchFilmById.do", params = "searchFilmById", method = RequestMethod.GET)
	public ModelAndView searchFilmById(@RequestParam("searchFilmById") int id) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("view");
		mv.addObject("film", dao.searchFilmById(id));

		return mv;
	}

	// This method will use the action "searchFilmByKeyword.do" via
	// ./WebContent/searchFilmByKeyword.html and retrieve a *list* of films
	// associated with the key "film" to display on our view.jsp page
	@RequestMapping(path = "searchFilmByKeyword.do", params = "searchFilmByKeyword", method = RequestMethod.GET)
	public ModelAndView searchFilmByKeyword(@RequestParam("searchFilmByKeyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FilmList");
		mv.addObject("film", dao.findFilmByKeyword(keyword));
		return mv;
	}
	
	@RequestMapping(path = "Details.do", method = RequestMethod.GET)
	public ModelAndView filmDetails(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("film", f);
		return mv;
	}
	
	@RequestMapping(path = "Edit.do", method = RequestMethod.POST)
	public ModelAndView editFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EditFilm");
		mv.addObject("film", f);
		// calls method in FilmDAOImpl that edits film
		return mv;
	}
	
	@RequestMapping(path = "RouteToEdit.do", method = RequestMethod.GET)
	public ModelAndView routeToEditFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EditFilm");
		mv.addObject("film", f);
		return mv;
	}
	
	@RequestMapping(path = "Delete.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmationDelete");
		// calls method in FilmDAOImpl that deletes film 
		return mv;
	}
	
	@RequestMapping(path = "RouteToDelete.do", method = RequestMethod.GET)
	public ModelAndView routeToDelete(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmationDelete");
		return mv;
	}
}
