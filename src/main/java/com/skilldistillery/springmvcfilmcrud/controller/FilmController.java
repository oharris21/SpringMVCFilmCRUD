package com.skilldistillery.springmvcfilmcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.springmvcfilmcrud.database.FilmDAO;
import com.skilldistillery.springmvcfilmcrud.entities.Actor;
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
	// CORRESPONDS TO *searchFilmById.html*
	@RequestMapping(path = "searchFilmById.do", params = "searchFilmById", method = RequestMethod.GET)
	public ModelAndView searchFilmById(@RequestParam("searchFilmById") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		
		// Create film object using passed in id value
		Film film = dao.searchFilmById(id);
		
		// Set the category instance variable for the film object by calling
		// FilmDAOImpl.java/findCategoryByFilmId() method
		film.setCategory(dao.findCategoryByFilmId(id));
		film.setActors(dao.getActorsByFilmId(id));
		mv.addObject("film", film);
		return mv;
	}

	// This method will use the action "searchFilmByKeyword.do" via
	// ./WebContent/searchFilmByKeyword.html and retrieve a *list* of films
	// associated with the key "film" to display on our view.jsp page
	// CORRESPONDS TO *searchFilmByKeyword.html*
	@RequestMapping(path = "searchFilmByKeyword.do", params = "searchFilmByKeyword", method = RequestMethod.GET)
	public ModelAndView searchFilmByKeyword(@RequestParam("searchFilmByKeyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FilmList");
		mv.addObject("film", dao.findFilmByKeyword(keyword));
		return mv;
	}

	// CORRESPONDS TO *FilmList.jsp*
	@RequestMapping(path = "Details.do", method = RequestMethod.GET)
	public ModelAndView filmDetails(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		f.setActors(dao.getActorsByFilmId(f.getId()));
		mv.addObject("film", f);
		return mv;
	}

	// CORRESPONDS TO *EditFilm.jsp*
	@RequestMapping(path = "Edit.do", method = RequestMethod.POST)
	public ModelAndView editFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmationEdit");
		boolean editFilm = dao.editFilm(f);
		mv.addObject("editBoolean", editFilm);
		f.setCategory(dao.findCategoryByFilmId(f.getId()));
		f.setActors(dao.getActorsByFilmId(f.getId()));
		mv.addObject("film", f);
		return mv;
	}

	// This method occurs when the user clicks on the "Submit" button
	// inside of *FilmList.jsp* which takes them to a page where the form
	// value attributes are pre-set, allowing the user to change them as 
	// they see fit.
	// CORRESPONDS TO *FilmList.jsp*
	@RequestMapping(path = "RouteToEdit.do", method = RequestMethod.GET)
	public ModelAndView routeToEditFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EditFilm");
		mv.addObject("film", f);
		return mv;
	}

	// CORRESPONDS TO *FilmList.jsp, view.jsp*
	@RequestMapping(path = "Delete.do", params = "id", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("id") int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		// This line is here because we use the filmId that is passed in
		// to retrieve a film object so that we can set a key for the film
		// corresponding to the id. We set this key because we want to be 
		// able to retrieve the film's title, so that we can display to
		// the user which film was or was not deleted on confirmationDelete.jsp
		Film filmPropertiesToDisplayOnPage = dao.searchFilmById(filmId);
		
		boolean wasDeleteSuccessful = dao.deleteFilm(filmId);
		
		redir.addFlashAttribute("title", filmPropertiesToDisplayOnPage.getTitle());
		redir.addFlashAttribute("condition", wasDeleteSuccessful);
		
		mv.setViewName("redirect:redirectDelete.do");
		return mv;
	}
	
	// CORRESPONDS TO *deleteFilm() redirect*
	@RequestMapping(path = "redirectDelete.do", method = RequestMethod.GET)
	public ModelAndView deleteFilmRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmationDelete");
		return mv;
	}
	
	// CORRESPONDS TO *addFilm.html*
	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		Film addedFilm = dao.addFilmToDB(f);
		String successful = "Film addition successful";
		String failed = "Film addition failed";
		if (addedFilm != null) {
			mv.addObject("film", addedFilm);
			mv.addObject("successful", successful);
		} else if (addedFilm == null) {
			mv.addObject("failed", failed);
		}
		return mv;
	}
}
