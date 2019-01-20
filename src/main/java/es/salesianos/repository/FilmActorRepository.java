package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.ActorFilmDTO;
import es.salesianos.model.FilmActor;

public class FilmActorRepository extends Repository {

	private static final String jdbcUrl = getJdbcUrl();
	AbstractConnection manager = getManager();
	private static final Logger log = LogManager.getLogger(FilmActorRepository.class);

	public void insert(FilmActor filmActor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO FILMACTOR (cache, role, codActor, codFilm) VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, filmActor.getCache());
			preparedStatement.setString(2, filmActor.getRole());
			preparedStatement.setInt(3, filmActor.getCodActor());
			preparedStatement.setInt(4, filmActor.getCodFilm());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public ActorFilmDTO filterActorFilm(String role) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ActorFilmDTO actorFilm = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT TITTLE, NAME, YEAROFBIRTHDATE FROM ((FILMACTOR"
					+ " INNER JOIN FILM ON FILM.COD = FILMACTOR.CODFILM)"
					+ " INNER JOIN ACTOR ON ACTOR.COD = FILMACTOR.CODACTOR) WHERE FILMACTOR.ROLE LIKE CONCAT('%',(?),'%')");
			preparedStatement.setString(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ActorFilmDTO actorFilmfromDataBase = new ActorFilmDTO();
				actorFilmfromDataBase.setTitle(resultSet.getString(1));
				actorFilmfromDataBase.setName(resultSet.getString(2));
				actorFilmfromDataBase.setBirthYear(resultSet.getInt(3));
				actorFilm = actorFilmfromDataBase;
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return actorFilm;
	}

}
