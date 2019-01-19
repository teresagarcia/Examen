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
import es.salesianos.model.Actor;

public class ActorRepository extends Repository {

	private static final String jdbcUrl = getJdbcUrl();
	AbstractConnection manager = getManager();
	private static final Logger log = LogManager.getLogger(ActorRepository.class);

	public List<Actor> selectAllActor() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Actor> list = new ArrayList<Actor>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM ACTOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setCod(resultSet.getInt(1));
				actor.setName(resultSet.getNString(2));
				actor.setBirthYear(resultSet.getInt(3));
				list.add(actor);
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

	public void insert(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ACTOR (name,yearOfBirthDate)" + "VALUES (?, ?)");
			preparedStatement.setString(1, actor.getName());
			preparedStatement.setInt(2, actor.getBirthYear());
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
			preparedStatement = conn.prepareStatement("DELETE FROM ACTOR WHERE cod=?");
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

	public Actor findByCod(int code) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Actor actor = new Actor();
		try {
			preparedStatement = conn.prepareStatement("SELECT cod, name, yearOfBirthDate FROM ACTOR WHERE cod=?");
			preparedStatement.setInt(1, code);
			ResultSet resultSet = preparedStatement.executeQuery();
			actor.setCod(resultSet.getInt(1));
			actor.setName(resultSet.getNString(2));
			actor.setBirthYear(resultSet.getInt(3));

		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return actor;
	}

	public List<Actor> filterActor(int startYear, int endYear) {
		List<Actor> actorsList = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT cod, name, yearOfBirthDate FROM ACTOR WHERE yearOfBirthDate between ? AND ?");
			prepareStatement.setInt(1, startYear);
			prepareStatement.setInt(2, endYear);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Actor actorInDatabase = new Actor();
				actorInDatabase.setCod(resultSet.getInt(1));
				actorInDatabase.setName(resultSet.getString(2));
				actorInDatabase.setBirthYear(resultSet.getInt(3));
				actorsList.add(actorInDatabase);
			}

		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}

		return actorsList;
	}


}
