package es.salesianos.repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;

public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	private AbstractConnection manager = new H2Connection();

	public static String getJdbcUrl() {
		return jdbcUrl;
	}

	public AbstractConnection getManager() {
		return manager;
	}

	public void setManager(AbstractConnection manager) {
		this.manager = manager;
	}

}
