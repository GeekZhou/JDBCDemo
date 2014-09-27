package dbManipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testsqlexception {

	public static void main(String args[]) {

		String url = "jdbc:mysql://localhost:3306/samp_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "zhouzheng";

		try {
			Class.forName(driver);
		} catch (Exception e) {
		}
		try {
			Connection con = DriverManager.getConnection(url, "", "aa");
		} catch (SQLException e) {
			e.printStackTrace();
			while (e != null) {
				System.out.println("SQL state:  " + e.getSQLState());
				System.out.println("wrong information: " + e.getMessage());
				System.out.println("wrong code:   " + e.getErrorCode());
				e = e.getNextException();
			}
		}
	}

}
