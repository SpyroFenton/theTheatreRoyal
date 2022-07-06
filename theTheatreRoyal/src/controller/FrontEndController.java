package controller;

import util.DBConnector;
import util.InputReader;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Person;

public class FrontEndController {
	
	public static void main(String[] args) {
		DBConnector db = new DBConnector();
		// connect to the database
		db.connect();
	}
	
	public ResultSet runQuery(String sql) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // allows us to move forward and back in
																				// the ResultSet
					ResultSet.CONCUR_UPDATABLE);
			pst.execute();

			ResultSet results = pst.getResultSet();

			/* */
			if (results != null) {
				int rowcount = 0;
				if (results.last()) {
					rowcount = results.getRow();
					results.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first
											// element
				}
				System.out.println(sql + "\n Success.  Result set has " + rowcount + " rows");
			} else {
				System.out.println(sql + "\n Success.  No results returned");
			}
			/* */
			return results;
		} catch (SQLException e) {
			System.out.println(sql + "\n failed to run.");
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * select everything from the Person table, convert to a list of Person objects
	 * and print each Person object.
	 */
	public void selectshowProduction() {
		// run the select statement
		ResultSet rs = runQuery("SELECT * FROM Person");
		// convert the result set to a list of Person objects
		ArrayList<Person> everyone = getPeople(rs);
		// print the size of the list
		System.out.println("There are " + everyone.size() + " people in the database");
		// print each person using the toString() method in the Person class
		for (Person p : everyone) {
			System.out.println(p);
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
	
}
