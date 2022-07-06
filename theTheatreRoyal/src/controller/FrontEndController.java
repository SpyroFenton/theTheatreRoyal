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

		printGreeting();

		String choice = null;
		while (choice == null) {

			choice = in.getText("Please choose an option: 1.List shows, 2.Search by name, 3.Search by date, Exit");
			if (choice.equals("1")) {
				db.listShowProduction();
				choice = null;
			}

			else if (choice.equals("2")) {
				db.searchShowByName();
				choice = null;
			}

			else if (choice.equals("3")) {
				db.searchShowByDate();
				choice = null;

			} else if (choice.equals("exit")) {
				System.out.println("Exiting");
				break;
			}

			else {
				System.out.println("Invalid choice");
				choice = null;
			}
		}

	}

	public static void printGreeting() {
		System.out.println("Welcome");
	}

}
