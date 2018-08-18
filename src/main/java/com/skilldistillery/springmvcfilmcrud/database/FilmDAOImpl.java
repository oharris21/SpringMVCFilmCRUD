package com.skilldistillery.springmvcfilmcrud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
