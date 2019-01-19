package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Film;

public class FilmRepository extends Repository {

	private static final String jdbcUrl = getJdbcUrl();
	AbstractConnection manager = getManager();
	private static final Logger log = LogManager.getLogger(FilmRepository.class);

	public List<Film> selectAllFilm() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Film> list = new ArrayList<Film>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM FILM");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setCod(resultSet.getInt(1));
				film.setTitle(resultSet.getString(2));
				film.setCodDirector(resultSet.getInt(3));
				list.add(film);
			}

		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}

	public void insert(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO FILM	 (tittle, codOwner)" + "VALUES (?, ?)");
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setInt(2, film.getCodDirector());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void delete(int code) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM FILM WHERE cod = ?");
			preparedStatement.setInt(1, code);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		
	}

}
