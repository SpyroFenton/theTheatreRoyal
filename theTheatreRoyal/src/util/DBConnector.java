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

import model.User;

public class DBConnector {
	private Connection conn;
	private PreparedStatement myStmt;
	private ResultSet myRs;
	private InputReader in;
	private User user;

	public DBConnector() {
		conn = null;
		myStmt = null;
		myRs = null;
		in = new InputReader();
		user = new User();
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

	// query to list all shows
	public void listShowProduction() {

		try {
			// Create a statement
			Statement myStmt = conn.createStatement();

			// Execute SQL query
			myRs = myStmt.executeQuery("select * FROM showProduction");

			// Process the result set
			while (myRs.next()) {
				System.out.println("Show name: " + myRs.getString("showName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// query to list all shows by name
	public void searchShowByName() {

		try {
			// Prepare a statement
			myStmt = conn.prepareStatement(
					"SELECT showProduction.showName, showProduction.duration, performance.showDate, performance.showStartTime "
							+ "FROM showProduction " + "INNER JOIN performance "
							+ "ON showProduction.id = performance.showProductionID "
							+ "WHERE showProduction.showName = ?;");

			// Set the parameters
			myStmt.setString(1, in.getText("Enter show name: "));

			// Execute SQL query
			myRs = myStmt.executeQuery();

			System.out.println();
			System.out.println("Here are all available shows by name:");

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

	// query to list all shows by date
	public void searchShowByDate() {

		try {
			// Prepare a statement
			myStmt = conn.prepareStatement(
					"SELECT showProduction.showName, showProduction.duration, performance.showDate, performance.showStartTime "
							+ "FROM showProduction " + "INNER JOIN performance "
							+ "ON showProduction.id = performance.showProductionID "
							+ "WHERE performance.showDate = ?;");

			// Set the parameters
			myStmt.setString(1, in.getText("Enter show date in YYYY-MM-DD: "));

			// Execute SQL query
			myRs = myStmt.executeQuery();

			System.out.println();
			System.out.println("Here are all available shows by date:");

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

	public void addUserInfo() {
		user.setFirstName(in.getText("Enter first name"));
		user.setLastName(in.getText("Enter last name"));
		user.setAddressLine1(in.getText("Enter first line of address"));
		user.setAddressLine2(in.getText("Enter second line of address"));
		user.setCity(in.getText("Enter city"));
		user.setPostcode(in.getText("Enter postcode"));
		user.setEmail(in.getText("Enter eamil"));
		user.setPhoneNo(in.getText("Enter phone number"));
		user.setCcNumber(in.getText("Enter credit card number"));

		try {
			// Prepare a statement
			myStmt = conn.prepareStatement(
					"INSERT INTO customer (firstName, lastName, addressLine1, addressLine2, ciity, postcode, email, phoneNumber, creditCard) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

			// Set the parameters
			myStmt.setString(1, user.getFirstName());
			myStmt.setString(2, user.getLastName());
			myStmt.setString(3, user.getAddressLine1());
			myStmt.setString(4, user.getAddressLine2());
			myStmt.setString(5, user.getCity());
			myStmt.setString(6, user.getPostcode());
			myStmt.setString(7, user.getEmail());
			myStmt.setString(8, user.getPhoneNo());
			myStmt.setString(9, user.getCcNumber());

			// Execute SQL query
			myStmt.executeUpdate();

			// System.out.println();
			System.out.println("Insert complete");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
