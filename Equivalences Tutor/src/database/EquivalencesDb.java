package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquivalencesDb {

	public static boolean addNewEquivalence(StringBuilder left, StringBuilder right, int userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO equivalences (username, left, right) ");
		sql.append("VALUES(?, ?, ?)");
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseAdaptor.connect().prepareStatement(sql.toString());
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error connecting to DB on Register: PSQL driver not present");
			return false;
		}
		catch (SQLException e) {
			System.err.println("SQL Error on Register");
			return false;
		}
		try {
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, left.toString());
			preparedStatement.setString(3, right.toString());
			preparedStatement.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
