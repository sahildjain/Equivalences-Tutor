package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDb {
	
	public static int checkUserDetails(String username, String password) {
		String sql = "SELECT id FROM accounts WHERE username = ? AND password = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseAdaptor.connect().prepareStatement(sql);
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error connecting to DB on login: PSQL driver not present");
			e.printStackTrace();
			return 0;
		}
		catch (SQLException e) {
			System.err.println("SQL Error on login");
			return 0;
		}
		try {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, RegisterDb.sha256(password));
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next() || !resultSet.isLast()) {
				return 0;
			}
			int id = resultSet.getInt("id");
			return id;
		}
		catch (SQLException e) {
			return 0;
		}
	}
	
}