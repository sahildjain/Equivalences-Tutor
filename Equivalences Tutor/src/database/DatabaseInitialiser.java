package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;

public class DatabaseInitialiser {
	
	private final static String INITSQL_LOC = "/homes/sdj09/Individual Project/Equivalences-Tutor/Equivalences Tutor/src/database/init.sql";

	private static Connection connection = null;
	
	public static boolean init() {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(INITSQL_LOC));
			StringBuffer sb = new StringBuffer();
			String sqlLine;
			while((sqlLine = reader.readLine()) != null) {
				sb.append(sqlLine + "\n");
			}
			reader.close();
			connection = DatabaseAdaptor.connect();
			connection.createStatement().execute(sb.toString());
			connection.close();
			connection = null;
			
		}
		catch(Exception e) {
			System.err.println("currently looking for it in: " + INITSQL_LOC);
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
