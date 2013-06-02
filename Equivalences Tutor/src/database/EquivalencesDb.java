package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquivalencesDb {

	public static boolean addNewEquivalence(StringBuilder left, StringBuilder right, int userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO equivalence (account, lefteq, righteq) ");
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
	
	public static ResultSet getEquivalencesForUser(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT lefteq, righteq FROM equivalence WHERE account = ?;");
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseAdaptor.connect().prepareStatement(sql.toString());
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error connecting to DB on Register: PSQL driver not present");
			return null;
		}
		catch (SQLException e) {
			System.err.println("SQL Error on Register");
			return null;
		}
		try {
			preparedStatement.setInt(1, id);
			return preparedStatement.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int getNumberOfEquivalencesForUser(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM equivalence WHERE account = ?;");
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseAdaptor.connect().prepareStatement(sql.toString());
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error connecting to DB on Register: PSQL driver not present");
			return 0;
		}
		catch (SQLException e) {
			System.err.println("SQL Error on Register");
			return 0;
		}
		try {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int num = resultSet.getInt("count");
			return num;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
