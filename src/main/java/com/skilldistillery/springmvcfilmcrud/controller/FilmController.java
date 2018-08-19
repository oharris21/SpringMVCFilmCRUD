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
	// CORRESPONDS TO *searchFilmById.html*
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

	// CORRESPONDS TO *FilmList.jsp*
	@RequestMapping(path = "Delete.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(Film f) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmationDelete");
		// calls method in FilmDAOImpl that deletes film
		return mv;
	}

	// Commented out this method. *To be deleted?*
	// Message:
	// I don't think we need this method because when the user clicks on the 
	// delete button, that request mapping should jump to a delete method
	// which utilizes the FilmDAOImpl object method to delete the passed in
	// film object. The view in the controller delete method which calls the 
	// FilmDAOImpl delete method can just simply point to a page where
	// the user will get a confirmation that the method was deleted.
	// Perhaps this page will also contain the details of the film which
	// was just deleted. 
	//
	// The only reason that there is a "RouteToEdit.do" mapping for a method
	// in the controller is because when the user clicks the edit button
	// they need to get to a page where they can see form values for the 
	// film they wish to edit pre-populated, so they know what they can
	// change. Furthermore, the submit button on *that* page should be the 
	// one which actually calls the controller method which calls the 
	// FilmDAOImpl class' UPDATE film (aka edit) method. 
	// *** START METHOD ***
//	@RequestMapping(path = "RouteToDelete.do", method = RequestMethod.GET)
//	public ModelAndView routeToDelete(Film f) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("confirmationDelete");
//		return mv;
//	}
	// *** END METHOD ***

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
