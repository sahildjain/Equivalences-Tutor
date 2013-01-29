package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseAdaptor {
	
	private final static String URL = "";
	private final static String USER = "sdj09";
	private final static String PASSWORD = "";
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Properties properties = new Properties();
		properties.setProperty("user", USER);
		properties.setProperty("password", PASSWORD);
		Connection connection = DriverManager.getConnection(URL, properties);
		return connection;
	}

}
