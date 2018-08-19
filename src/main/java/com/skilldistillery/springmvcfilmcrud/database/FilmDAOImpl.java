package com.skilldistillery.springmvcfilmcrud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.springmvcfilmcrud.entities.Actor;
import com.skilldistillery.springmvcfilmcrud.entities.Film;

public class FilmDAOImpl implements FilmDAO {
	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String user = "student";
	private final String pass = "student";

	public FilmDAOImpl() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Override
	public Film searchFilmById(int filmId) {
		Film f = null;
		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration,\n"
				+ "       rental_rate, length, replacement_cost, rating, special_features, name\n" + "FROM film\n"
				+ "JOIN language\n" + "ON film.language_id = language.id\n" + "WHERE film.id = ?";
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

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, \n"
					+ "			 rental_rate, length, replacement_cost, rating, special_features, language.name\n"
					+ "FROM film\n" + "JOIN language\n" + "ON film.language_id = language.id\n"
					+ "WHERE title LIKE ? OR description LIKE ?";
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

	@Override
	public boolean editFilm(Film f) {
		Connection conn = null;
		Boolean edit = false;
		String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, "
				+ "rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ? "
				+ "where id = ?; ";
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, f.getTitle());
			stmt.setString(2, f.getDescription());
			stmt.setInt(3, f.getReleaseYear());
			stmt.setInt(4, f.getLanguageId());
			stmt.setInt(5, f.getRentalDuration());
			stmt.setDouble(6, f.getRentalRate());
			stmt.setInt(7, f.getLength());
			stmt.setDouble(8, f.getReplacementCost());
			stmt.setString(9, f.getRating());
			stmt.setString(10, f.getSpecialFeatures());
			stmt.setInt(11, f.getId());
			int rowsAffected = stmt.executeUpdate();
			System.out.println(rowsAffected);
			if (rowsAffected > 0) {
				edit = true;
			} else {
				edit = false;
			}
			conn.commit();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Error trying to rollback");
				}
			}
			
		}
		
		return edit;
	}

	@Override
	public boolean deleteFilm(int filmId) {
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM film WHERE film.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, filmId);
			
			int updateCount = stmt.executeUpdate();
			
			if (updateCount == 1) {
				System.out.println("Film successfully deleted from "
						+ "database.");
				return true;
			}
			
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			if (conn != null) {
				try {
					
					conn.rollback();
					
				} catch (SQLException e2) {
					
					System.err.println("Error trying to rollback");
					
				}
			}
			
		}
		// This will occur only if updateCount != 1, i.e. if the 
		// query command was unable to delete the film from the DB
		return false;
	}

	@Override
	public Film addFilmToDB(Film film) {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO film (film.title, film.description,"
					+ " film.release_year, film.language_id,"
					+ " film.rental_duration, film.rental_rate,"
					+ " film.length, film.replacement_cost, film.rating,"
					+ " film.special_features) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				System.out.println("Film successfully added to DB");
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);
					if (film.getActors() != null && film.getActors().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";

						stmt = conn.prepareStatement(sql);
						for (Actor actor : film.getActors()) {
							stmt.setInt(1, newFilmId);
							stmt.setInt(2, actor.getId());
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				film = null;
			}

			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Error trying to rollback");
				}
			}

			return film = null;
		}

		return film;
	}
}
