package com.skilldistillery.springmvcfilmcrud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.springmvcfilmcrud.entities.Film;

public class FilmDAOImpl implements FilmDAO{
	private static String url = "jdbc:mysql://localhost:3306/sdvid";
	private final String user = "student";
	private final String pass = "student";
	
	public FilmDAOImpl() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	@Override
	public Film searchFilmById(int filmId) {
		Film f = null;
		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration,\n" + 
				"       rental_rate, length, replacement_cost, rating, special_features, name\n" + 
				"FROM film\n" + 
				"JOIN language\n" + 
				"ON film.language_id = language.id\n" + 
				"WHERE film.id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				f = new Film(); 
				f.setId(filmResult.getInt(1));
				f.setTitle(filmResult.getString(2));
				f.setDescription(filmResult.getString(3));
				f.setReleaseYear(filmResult.getInt(4));
				f.setLanguageId(filmResult.getInt(5));
				f.setRentalDuration(filmResult.getInt(6));
				f.setRentalRate(filmResult.getDouble(7));
				f.setLength(filmResult.getInt(8));
				f.setReplacementCost(filmResult.getDouble(9));
				f.setRating(filmResult.getString(10));
				f.setSpecialFeatures(filmResult.getString(11));
				f.setLanguage(filmResult.getString(12));
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	// keyword search in database  
	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>(); 
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, \n" + 
				"			 rental_rate, length, replacement_cost, rating, special_features, language.name\n" + 
				"FROM film\n" + 
				"JOIN language\n" + 
				"ON film.language_id = language.id\n" + 
				"WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql); 
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery(); 
			while (rs.next()) {
				int filmId = rs.getInt(1);
				String title = rs.getString(2);
				String desc = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int langId = rs.getInt(5);
				int rentDur = rs.getInt(6);
				double rate = rs.getDouble(7);
				int length = rs.getInt(8);
				double repCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String features = rs.getString(11);
				String language = rs.getString(12); 
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
					features, language);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}
	
	public Boolean editFilm(Film f) {
		Boolean edit = false; 
		String sql = "UPDATE film\n" + 
				"SET id = ?, " + 
				"SET title = ?, " +
				"SET description = ?, " +
				"SET release_year = ?, " +
				"SET language_id = ?, " +
				"SET rental_duration = ?, " +
				"SET rental_rate = ?, " + 
				"SET length = ?, " +
				"SET replacement_cost = ?, " +
				"SET rating = ?, " +
				"SET special_features = ?, " +
				"SET language = ?, " + 
				"WHERE id = ?, " + 
				"WHERE title = ?, " +
				"WHERE description = ?, " +
				"WHERE release_year = ?, " +
				"WHERE language_id = ?, " +
				"WHERE rental_duration = ?, " +
				"WHERE rental_rate = ?, " + 
				"WHERE length = ?, " +
				"WHERE replacement_cost = ?, " +
				"WHERE rating = ?, " +
				"WHERE special_features = ?, " +
				"WHERE language = ?, ";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, f.getId());
			stmt.setString(2, f.getTitle());
			stmt.setString(3, f.getDescription());
			stmt.setInt(4, f.getReleaseYear());
			stmt.setInt(5, f.getLanguageId());
			stmt.setInt(6, f.getRentalDuration());
			stmt.setDouble(7, f.getRentalRate());
			stmt.setInt(8, f.getLength());
			stmt.setDouble(9, f.getReplacementCost());
			stmt.setString(10, f.getRating());
			stmt.setString(11, f.getSpecialFeatures());
			stmt.setString(12, f.getLanguage());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				edit = true; 
			}
			else {
				edit = false; 
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return edit; 
	}
	
//	public void deleteFilm(Film f) {
//		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration,\n" + 
//				"       rental_rate, length, replacement_cost, rating, special_features, name\n" + 
//				"FROM film\n" + 
//				"JOIN language\n" + 
//				"ON film.language_id = language.id\n" + 
//				"WHERE film.id = ?";
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.set(1, filmId);
//			ResultSet filmResult = stmt.executeQuery();
//			filmResult.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
