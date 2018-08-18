package com.skilldistillery.springmvcfilmcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.springmvcfilmcrud.database.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	FilmDAO dao; 
}
