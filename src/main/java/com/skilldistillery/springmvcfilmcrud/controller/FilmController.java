package com.skilldistillery.springmvcfilmcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.springmvcfilmcrud.database.FilmDAO;

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

}
