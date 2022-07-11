package controller;

import util.DBConnector;
import util.InputReader;

public class BackEndController {
	private DBConnector db;
	private InputReader in;

	public BackEndController() {
		db = new DBConnector();
		in = new InputReader();

		// connect to the database
		db.connect();

	}

	public void mainMenu() {

		System.out.println("Welcome please type a number to choose an option");
		System.out.println();
		System.out.println("1 - Show Calendar");
		System.out.println("2 - Buy ticket/(S)");
		System.out.println("3 - Basket");
		System.out.println("4 - Employee login");
		System.out.println("5 - Exit");

		boolean exit = false;

		do {
			switch (in.getNumber("")) {
			case 1:
				showCalendar();
				break;
			case 2:
				System.out.println("Insert Buy ticket/(S) method");
				loopBackMenu();
				break;
			case 3:
				System.out.println("Insert basket method");
				loopBackMenu();
				break;
			case 4:
				System.out.println("Insert employee method");
				loopBackMenu();
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Error: You must choose a valid option");
			}
		} while (!exit);
		exit();
	}

	public void showCalendar() {

		System.out.println("Please choose an option");
		System.out.println();
		System.out.println("1 - View all shows");
		System.out.println("2 - Browse shows by name");
		System.out.println("3 - Browse shows by date");
		System.out.println("4 - Main menu");
		System.out.println("5 - Exit");

		boolean exit = false;

		do {
			switch (in.getNumber("")) {
			case 1:
				System.out.println("Here are all available shows");
				System.out.println();
				db.listShowProduction();
				System.out.println();
				loopBackMenu();
				break;
			case 2:

				db.searchShowByName();
				System.out.println();
				loopBackMenu();
				break;
			case 3:
				db.searchShowByDate();
				System.out.println();
				loopBackMenu();
				break;
			case 4:
				mainMenu();
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Error: You must choose a valid option");
			}
		} while (!exit);
		exit();
	}

	public void exit() {
		System.out.println("Thank you for using TheatreRoyal");
		System.exit(0); // Exits the program
	}

	public void loopBackMenu() {
		System.out.println("Please choose an option");
		System.out.println();
		System.out.println("1 - Buy ticket/(S)");
		System.out.println("2 - Show Calendar");
		System.out.println("3 - Main menu");

		switch (in.getNumber("")) {
		case 1:
			System.out.println("Insert Buy ticket method");
			loopBackMenu();
			break;
		case 2:
			showCalendar();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void basket() {
		System.out.println("Please choose an option");

		System.out.println("1 - Go to payment");
		System.out.println("2 - Buy ticket/(S)");
		System.out.println("3 - Show Calendar");
		System.out.println("4 - Main menu");

		switch (in.getNumber("")) {
		case 1:
			System.out.println("Insert go to payment method");
			break;
		case 2:
			System.out.println("Insert Buy ticket/(S) method");
			loopBackMenu();
			break;
		case 3:
			showCalendar();
			break;
		case 4:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}
}