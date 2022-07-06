package controller;

import util.DBConnector;
import util.InputReader;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// import model.Person;

public class FrontEndController {
	
	public static void main(String[] args) {
		DBConnector db = new DBConnector();
		// connect to the database
		db.connect();
		
		// method to see if showproduction lists
		db.selectshowProduction();
		
		// method to list shows by name
		db.searchShowByName();
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
	
}
