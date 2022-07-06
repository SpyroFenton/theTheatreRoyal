package controller;

import util.DBConnector;
import util.InputReader;

// import model.Person;

public class FrontEndController {

	public FrontEndController() {
	}

	public static void main(String[] args) {
		DBConnector db = new DBConnector();
		InputReader in = new InputReader();
		// connect to the database
		db.connect();

		// method to list all shows
		// db.listShowProduction();

		// method to list shows by name
		// db.searchShowByName();

		// method to list shows by date
		// db.searchShowByDate();
		printGreeting();

		String choice = null;
		while (choice == null) {

			choice = in.getText("Please choose an option: 1.List shows, 2.Search by name, 3.Search by date");
			if (choice.equals("1")) {
				db.listShowProduction();
			}
			if (choice.equals("2")) {
				db.searchShowByName();
			}
			if (choice.equals("3")) {
				db.searchShowByDate();
			} else {
				// System.out.println("Invalid choice");
				choice = null;
			}

		}
	}

	public static void printGreeting() {
		System.out.println("Welcome");
	}

	public static void start() {
		printGreeting();
		DBConnector db = new DBConnector();
		InputReader read = new InputReader();

		String choice = null;

		while (choice == null) {

			choice = read.getText("Please choose an option: 1.List shows, 2.Search by name, 3.Search by date");
			if (choice.equals("1")) {
				db.listShowProduction();
			}

		}
	}
}
/*
 * public void start() { private String choice = null;
 * 
 * System.out.println("Welcome. Please choose either: Browse, search, date");
 * InputReader read = new InputReader();
 * 
 * while (choice == null) { String choice = read.getInputString();
 * 
 * if (choice.equalsIgnoreCase("Browse")) {
 * System.out.println("Browsing all shows"); choice = null;
 * 
 * }
 * 
 * else if (choice.equalsIgnoreCase("Search")) {
 * System.out.println("Search for show"); choice = null;
 * 
 * }
 * 
 * else if (choice.equalsIgnoreCase("date")) {
 * System.out.println("Search by date"); choice = null;
 * 
 * 
 * } else if (choice.equalsIgnoreCase("exit")) { System.out.println("Exiting");
 * break; }
 * 
 * else { System.out.println("Invalid choice"); choice = null; } }
 */
