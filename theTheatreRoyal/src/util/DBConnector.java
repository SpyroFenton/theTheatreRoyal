package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// import model.Person; our model

public class DBConnector {
	private Connection conn;
	private PreparedStatement myStmt;
	private ResultSet myRs;
	private InputReader in;

	public DBConnector() {
		conn = null;
		myStmt = null;
		myRs = null;
		in = new InputReader();
	}

	public void connect() {

		try {
			Scanner s = new Scanner(new File("credentials.txt"));
			String databaseUrl = s.nextLine();
			String user = s.nextLine();
			String pwd = s.nextLine();
			conn = DriverManager.getConnection(databaseUrl, user, pwd);
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
			System.exit(1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't find the credentials file");
			e.printStackTrace();
			System.exit(1);
		}

		if (conn != null) {
			// System.out.println("Connection established.");
		} else {
			System.out.println("Connection null still.");
			System.exit(1);
		}
	}

	public void listShowProduction() {

		try {
			// Create a statement
			Statement myStmt = conn.createStatement();

			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * FROM showProduction");

			// Process the result set
			while (myRs.next()) {
				System.out.println("Show name: " + myRs.getString("showName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchShowByName() {

		try {
			// Prepare a statement
			myStmt = conn
					.prepareStatement("SELECT\r\n" + "showProduction.showName,\r\n" + "showProduction.duration,\r\n"
							+ "performance.showDate,\r\n" + "performance.showStartTime\r\n" + "FROM showProduction\r\n"
							+ "INNER JOIN performance\r\n" + "ON showProduction.id = performance.showProductionID  \r\n"
							+ "WHERE showProduction.showName = ?;");

			// Set the parameters
			myStmt.setString(1, in.getText("Enter show name: "));

			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Display the result set
			while (myRs.next()) {
				System.out.println(
						"Show name: " + myRs.getString("showName") + " Duration: " + myRs.getString("duration"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchShowByDate() {

		try {
			// Prepare a statement
			myStmt = conn.prepareStatement("SELECT\r\n" + "showProduction.showName,\r\n"
					+ "showProduction.duration,\r\n" + "performance.showDate,\r\n" + "performance.showStartTime\r\n"
					+ "FROM showProduction\r\n" + "INNER JOIN performance\r\n"
					+ "ON showProduction.id = performance.showProductionID  \r\n" + "WHERE performance.showDate = ?;");

			// Set the parameters
			myStmt.setString(1, in.getText("Enter show date in YYYY-MM-DD: "));

			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Display the result set
			while (myRs.next()) {
				System.out.println(
						"Show name: " + myRs.getString("showName") + " Duration: " + myRs.getString("duration"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
