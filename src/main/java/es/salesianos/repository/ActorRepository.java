package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Actor;

public class ActorRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return actor;
	}

}
