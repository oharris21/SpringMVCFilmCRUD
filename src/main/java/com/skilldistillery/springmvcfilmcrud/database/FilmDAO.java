package com.skilldistillery.springmvcfilmcrud.database;

import java.util.List;

import com.skilldistillery.springmvcfilmcrud.entities.Film;

public interface FilmDAO {
	public Film searchFilmById(int id); 
	public List<Film> findFilmByKeyword(String keyword); 
	public Film addFilmToDB(Film film);
	public boolean editFilm(Film f); 
	public boolean deleteFilm(int filmId);
}
