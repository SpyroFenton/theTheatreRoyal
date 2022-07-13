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

import controller.BackEndController;
import model.Basket;
import model.Performance;
import model.Show;
import model.Ticket;
import model.User;

public class DBConnector {

	private Connection conn;
	private PreparedStatement myStmt;
	private ResultSet myRs;
	private InputReader in;
	private User user;
	public Ticket ticket;
	private Show show;
	private Basket basket;
	private Performance performance;

	public DBConnector() {
		conn = null;
		myStmt = null;
		myRs = null;
		in = new InputReader();
		user = new User();
		ticket = new Ticket();
		show = new Show();
		basket = new Basket();
		performance = new Performance();
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

	// method to show data
	public void printShowData(ResultSet myRs) {

		try {

			BackEndController bec = new BackEndController();
			System.out.println();
			System.out.println(bec.formatter());
			System.out.println("			Performance no." + myRs.getString("performance.id"));
			System.out.println("Name: " + myRs.getString("showProduction.showName"));
			System.out.println("Description: " + myRs.getString("showProduction.showDescription"));
			System.out.println("Date: " + myRs.getDate("performance.showDate"));
			System.out.println("Duration: " + myRs.getString("showProduction.duration") + " minutes");
			System.out.println("Language: " + myRs.getString("showProduction.language"));
			System.out.println("Genre: " + myRs.getString("showProduction.typeID"));
			System.out.println("Stall Price: �" + myRs.getDouble("showProduction.stallPrice")
					+ "	Stall Availibility: " + myRs.getInt("performance.totalAvailibilityStalls"));
			System.out.println("Circle Price: �" + myRs.getDouble("showProduction.circlePrice")
					+ "	Circle Availibility: " + myRs.getInt("performance.totalAvailibilityCircle"));
			System.out.println(bec.formatter());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Select statement variables
	public String selectStatement() {
		return "SELECT showProduction.showName, showProduction.showDescription, showProduction.duration, showProduction.language, showProduction.typeID, showProduction.liveAccompaniment, showProduction.circlePrice, showProduction.stallPrice, "
				+ "performance.id, performance.showDate, performance.showStartTime, performance.totalAvailibilityStalls, performance.totalAvailibilityCircle "
				+ "FROM showProduction " + "INNER JOIN performance "
				+ "ON showProduction.id = performance.showProductionID";
	}

	// query to list all shows
	public void listShowProduction() {

		try {
			int rowcount = 0;

			// Create a statement
			Statement myStmt = conn.createStatement();

			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery(selectStatement());

			// Process the result set
			while (myRs.next()) {
				printShowData(myRs);
				rowcount = myRs.getRow();
			}
			// Display total results
			System.out.println("Total results: " + rowcount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// query to list all shows by name
	public void searchShowByName() {

		try {
			int rowcount = 0;

			// Prepare a statement
			myStmt = conn.prepareStatement(selectStatement() + " WHERE showProduction.showName = ?;");

			// Set the parameters
			myStmt.setString(1, in.getText("Enter show name: "));

			// Execute SQL query
			myRs = myStmt.executeQuery();

			System.out.println();
			System.out.println("Here are all available shows by name:");

			// Display the result set
			while (myRs.next()) {
				printShowData(myRs);
				rowcount = myRs.getRow();
			}
			// Display total results
			System.out.println("Total results: " + rowcount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// query to list all shows by date
	public void searchShowByDate() {

		try {
			int rowcount = 0;

			// Prepare a statement
			myStmt = conn.prepareStatement(selectStatement() + " WHERE performance.showDate = ?;");

			// Set the parameters
			myStmt.setString(1, in.getText("Enter show date in YYYY-MM-DD: "));

			// Execute SQL query
			myRs = myStmt.executeQuery();

			System.out.println();
			System.out.println("Here are all available shows by date:");
			System.out.println();

			// Display the result set
			while (myRs.next()) {
				printShowData(myRs);
				rowcount = myRs.getRow();
			}
			// Display total results
			System.out.println("Total results: " + rowcount);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void userIDInput() {
		ticket.setPerformanceID(in.getText("Enter performance no. of the ticket you wish to buy"));
		try {

			// Prepare a statement
			myStmt = conn.prepareStatement(selectStatement() + " WHERE performance.id = ?;");

			// Set the parameters
			myStmt.setString(1, ticket.getPerformanceID());

			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Display the result set
			while (myRs.next()) {
				printShowData(myRs);

				ticket.setShowName(myRs.getString("showProduction.showName"));
				System.out.println(ticket.getShowName());

				show.setDuration(myRs.getInt("showProduction.duration"));
				System.out.println(show.getDuration());

				// language and genre setter/getters need to be added to class if we want them
				// displayed on ticket

				ticket.setStartTime(myRs.getString("performance.showStartTime"));
				System.out.println(ticket.getStartTime());

				ticket.setDate(myRs.getString("performance.showDate"));
				System.out.println(ticket.getDate());

				performance.setCircleAvailable(myRs.getInt("performance.totalAvailibilityCircle"));
				System.out.println(performance.getCircleAvailable());

				performance.setStallsAvailable(myRs.getInt("performance.totalAvailibilityStalls"));
				System.out.println(performance.getStallsAvailable());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double circlePrice() {
		double circlePrice = 0;
		try {

			// Prepare a statement
			myStmt = conn.prepareStatement(
					"SELECT showProduction.circlePrice FROM showProduction INNER JOIN performance ON showProduction.id = performance.showProductionID WHERE performance.id = ?;");

			// Set the parameters
			myStmt.setString(1, ticket.getPerformanceID());

			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Display the result set
			while (myRs.next()) {
				circlePrice = myRs.getDouble("showProduction.circlePrice");
				show.setCirclePrice(circlePrice);

				// Test to see circle price has stored from database
				System.out.println(show.getCirclePrice());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return circlePrice;

	}

	public double stallsPrice() {
		double stallsPrice = 0;
		try {

			// Prepare a statement
			myStmt = conn.prepareStatement(
					"SELECT showProduction.stallPrice FROM showProduction INNER JOIN performance ON showProduction.id = performance.showProductionID WHERE performance.id = ?;");

			// Set the parameters
			myStmt.setString(1, ticket.getPerformanceID());

			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Display the result set
			while (myRs.next()) {
				stallsPrice = myRs.getDouble("showProduction.stallPrice");
				show.setStallsPrice(stallsPrice);

				// Test to see circle price has stored from database
				System.out.println(show.getStallsPrice());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stallsPrice;
	}

	// this method will be used at the end for payment
	public void setCustomerInfo() {
		user.setFirstName(in.getText("Enter first name"));
		user.setLastName(in.getText("Enter last name"));
		user.setAddressLine1(in.getText("Enter first line of address"));
		user.setAddressLine2(in.getText("Enter second line of address"));
		user.setCity(in.getText("Enter city"));
		user.setPostcode(in.getText("Enter postcode"));

	}

	public void injectCustomerInfo() {

		try {
			// Prepare a statement
			myStmt = conn.prepareStatement(
					"INSERT INTO customer (firstName, lastName, addressLine1, addressLine2, city, postcode) "
							+ "VALUES (?, ?, ?, ?, ?, ?);");

			// Set the parameters
			myStmt.setString(1, user.getFirstName());
			myStmt.setString(2, user.getLastName());
			myStmt.setString(3, user.getAddressLine1());
			myStmt.setString(4, user.getAddressLine2());
			myStmt.setString(5, user.getCity());
			myStmt.setString(6, user.getPostcode());

			// Execute SQL query
			myStmt.executeUpdate();

			// System.out.println();
			// System.out.println("Insert complete");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertTransactionID() {

		try {
			// Prepare a statement
			String sqlInsert = "INSERT INTO transactionID (timestamp, CustomerID) VALUES (?, LAST_INSERT_ID());";
			myStmt = conn.prepareStatement(sqlInsert);

			// Set the parameters
			myStmt.setTimestamp(1, TimeStamp.getTimestamp());

			// Execute SQL query
			myStmt.executeUpdate();

			System.out.println("Insert complete.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSeatAvailibility() {

		for (int i = 0; i < basket.getNoOfTotalTickets(); i++) {
			String performanceID = null;
			if (basket.tickets.get(i).getSeatType().equals("Circle")) {
				performanceID = basket.tickets.get(i).getPerformanceID();
				try {
					// Prepare a statement
					String sqlInsert = ("UPDATE performance SET totalAvailibilityCircle = totalAvailibilityCircle - 1 WHERE performance.id = ?;");
					myStmt = conn.prepareStatement(sqlInsert);

					// Set the parameters
					myStmt.setString(1, performanceID);

					// Execute SQL query
					myStmt.executeUpdate();

					System.out.println("Insert complete..");
					// System.out.println(seatType);
					// System.out.println(performanceID);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (basket.tickets.get(i).getSeatType().equals("Stalls")) {
				performanceID = basket.tickets.get(i).getPerformanceID();
				try {
					// Prepare a statement
					String sqlInsert = ("UPDATE performance SET totalAvailibilityStalls = totalAvailibilityStalls - 1 WHERE performance.id = ?;");
					myStmt = conn.prepareStatement(sqlInsert);

					// Set the parameters
					myStmt.setString(1, performanceID);

					// Execute SQL query
					myStmt.executeUpdate();

					System.out.println("Insert complete..");
					// System.out.println(seatType);
					// System.out.println(performanceID);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// performanceID = basket.tickets.get(i).getPerformanceID();

		}
	}

	public void updateSeatAvailibilityCirlce() {

		String performanceID = ticket.getPerformanceID();

		try {
			// Prepare a statement
			String sqlInsert = ("UPDATE performance SET totalAvailibilityCircle = totalAvailibilityCircle - 1 WHERE performance.id = ?;");
			myStmt = conn.prepareStatement(sqlInsert);

			// Set the parameters
			myStmt.setString(1, performanceID);

			// Execute SQL query
			myStmt.executeUpdate();

			System.out.println("Insert complete..");
			// System.out.println(seatType);
			// System.out.println(performanceID);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateSeatAvailibilityStalls() {

		String performanceID = ticket.getPerformanceID();
		try {
			// Prepare a statement
			String sqlInsert = ("UPDATE performance SET totalAvailibilityStalls = totalAvailibilityStalls - 1 WHERE performance.id = ?;");
			myStmt = conn.prepareStatement(sqlInsert);

			// Set the parameters
			myStmt.setString(1, performanceID);

			// Execute SQL query
			myStmt.executeUpdate();

			System.out.println("Insert complete..");
			// System.out.println(seatType);
			// System.out.println(performanceID);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
