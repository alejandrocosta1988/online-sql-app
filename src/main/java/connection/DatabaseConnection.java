package connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Connection connection = null;
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/onlineSQL";
	private static String user = "root";
	private static String password = "";
	
	public static Connection getConnection() {
		return connection;
	}
	
	public DatabaseConnection() {
		connect();
	}
	
	static {
		connect();
	}
	
	private static void connect() {
		
		try {
			
			
			if (connection == null) {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(dbUrl, user, password);
				connection.setAutoCommit(false);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
