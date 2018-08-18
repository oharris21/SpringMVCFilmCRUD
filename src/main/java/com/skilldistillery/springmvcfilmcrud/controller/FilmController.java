package com.skilldistillery.springmvcfilmcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.springmvcfilmcrud.database.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO dao;

	public void setFilmDAO(FilmDAO filmDAO) {
		dao = filmDAO;
	}
	
}
