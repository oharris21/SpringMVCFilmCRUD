package com.skilldistillery.springmvcfilmcrud.database;

import com.skilldistillery.springmvcfilmcrud.entities.Film;

public interface FilmDAO {
	public Film searchFilmById(int id); 

}
