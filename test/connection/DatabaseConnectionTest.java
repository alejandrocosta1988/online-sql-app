package connection;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {
	
	private Connection connection;

	@Test
	void connectMethodSuccessfullyConnectsToTheDatabase() {
		
		connection = DatabaseConnection.getConnection();
		
		assertTrue(connection != null);
		
	}

}
