package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

// import model.Person; our model

public class DBConnector {
	private Connection conn;

	public DBConnector() {
		conn = null;
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
			System.out.println("Connection established.");
		} else {
			System.out.println("Connection null still.");
			System.exit(1);
		}
	}

	
	/**
	 * select everything from the Person table, convert to a list of Person objects
	 * and print each Person object.
	 */
	public void selectshowProduction() {
		
		try {
			// Create a statement
			Statement myStmt =  conn.createStatement();
			
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * FROM showProduction");
			
			// Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("showName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
