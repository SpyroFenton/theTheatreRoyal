package controller;

import model.Basket;
import model.Ticket;
import util.DBConnector;
import util.InputReader;
import util.InputValidator;

public class BackEndController {
	private DBConnector db;
	private InputReader in;
	private Basket basket;
	private Ticket ticket;
	private InputValidator inputValidator;

	public BackEndController() {
		db = new DBConnector();
		in = new InputReader();
		basket = new Basket();
		ticket = new Ticket();
		inputValidator = new InputValidator();

		// connect to the database
		db.connect();
	}

	public void mainMenu() {

		System.out.println("Welcome please type a number to choose an option");
		System.out.println();
		System.out.println(formatter());
		System.out.println("1 - View What's On/Calendar");
		// System.out.println("2 - Buy ticket/(S)");
		System.out.println("2 - View basket");
		System.out.println("3 - Employee login");
		System.out.println("4 - Exit");
		System.out.println(formatter());

		boolean exit = false;

		do {
			switch (in.getNumber("")) {
			case 1:
				showCalendar();
				break;
			case 2:
				System.out.println("Insert basket method");
				viewBasket();
				// loopBackMenu();
				break;
			case 3:
				System.out.println("Insert employee method");
				loopBackMenu();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Error: You must choose a valid option");
			}
		} while (!exit);
		exit();
	}

	public String formatter() {
		// return "--------------------------------------------------------------";
		return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	}

	public void showCalendar() {

		System.out.println("Please choose an option");
		// System.out.println();
		System.out.println(formatter());
		System.out.println("1 - View all shows");
		System.out.println("2 - Browse shows by name");
		System.out.println("3 - Browse shows by date");
		System.out.println("4 - Main menu");
		System.out.println("5 - Exit");
		System.out.println(formatter());

		boolean exit = false;

		do {
			switch (in.getNumber("")) {
			case 1:
				System.out.println("Here are all available shows:");
				db.listShowProduction();
				System.out.println();
				buyMethod();
				// loopBackMenu();

				break;
			case 2:
				db.searchShowByName();
				System.out.println();
				buyMethod();
				break;
			case 3:
				db.searchShowByDate();
				System.out.println();
				buyMethod();
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
		// System.out.println();
		System.out.println(formatter());
		System.out.println("1 - Buy ticket/(S)");
		System.out.println("2 - Show Calendar");
		System.out.println("3 - Main menu");
		System.out.println(formatter());

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

	public void buyMethod() {
		System.out.println("Please choose an option");
		// System.out.println();
		System.out.println(formatter());
		System.out.println("1 - Buy ticket");
		System.out.println("2 - Main menu");
		System.out.println(formatter());

		switch (in.getNumber("")) {
		case 1:
			db.userIDInput();
			showConfirmation();
			break;
		case 2:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void showConfirmation() {
		System.out.println("Is this the correct ticket [y/n]");

		switch (in.getText("")) {
		case "y":
			newTicket();
			break;
		case "n":
			buyMethod();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void newTicket() {
		// user selects seat Type
		//
		// CREATE Instance of ticket i.e. Ticket ticket = new Ticket();
		//
		System.out.println("Enter Seat type:");
		System.out.println("1- Circle");
		System.out.println("2- Stalls");
		String seatType = "";
		switch (in.getNumber("")) {
		case 1:
			double circlePrice = db.circlePrice();
			// set circle price in ticket
			ticket.setPrice(circlePrice);
			System.out.println(circlePrice); // print to test setprice method worked
			seatType = "Circle";

			break;
		case 2:
			double stallsPrice = db.stallsPrice();
			// set stall price in ticket
			ticket.setPrice(stallsPrice);
			System.out.println(stallsPrice); // print to test setprice method worked
			seatType = "Stalls";

			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}

		// user select concession options

		System.out.println("Enter Concession type:");
		System.out.println("1- Regular (no concession)");
		System.out.println("2- Student");
		System.out.println("3- Under 16");
		String concession = "";
		switch (in.getNumber("")) {
		case 1:
			concession = "Regular";
			ticket.setConcession(concession);
			break;
		case 2:
			concession = "Student";
			ticket.setConcession(concession);
			// ticket.applyConcession;
			break;
		case 3:
			// set stall price in ticket
			concession = "Under 16";
			ticket.setConcession(concession);
			// ticket.applyConcession
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}

		// set ticket info (showName, duration bla bla bla)
		// basket.addTicket(ticket)

		// select an option
		// get out of menu
		// view basket

	}

	public void seatSelector() {
		System.out.println("Enter Seat type:");
		System.out.println("1- Circle");
		System.out.println("2- Stall");

		switch (in.getNumber("")) {
		case 1:
			// set circle price in ticket

			break;
		case 2:
			// set stall price in ticket

			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void viewBasket() {

		// display contents of basket
		basket.displayBasket();

		System.out.println("Please choose an option");
		System.out.println(formatter());
		System.out.println("1 - Go to payment");
		System.out.println("2 - Clear basket");
		System.out.println("3 - Return to main menu");
		System.out.println(formatter());

		switch (in.getNumber("")) {
		case 1:
			paymentMenu();
			break;
		case 2:
			ClearBasket();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void paymentMenu() {
		System.out.println("In order to confirm your payment please enter your Credit Card number");
		String cc = in.getText("");
		@SuppressWarnings("unused") // boolean valid is not current used

		// OVERRIDE VALIDATE METHOD FOR NOW
		// TO DO
		//
		//
		//

		//
		//
		// boolean valid = inputValidator.validateCreditCard(cc);
		boolean valid = true;
		if (valid = true) {
			System.out.println("Details are correct. Processing your order now.");
		} else if (valid = false) {
			System.out.println("Please choose an option");
			System.out.println(formatter());
			System.out.println("1 - Try again");
			System.out.println("2 - Back to basket");
			switch (in.getNumber("")) {
			case 1:
				paymentMenu();
				break;
			case 2:
				viewBasket();
				break;
			}
		}
		//
		//
		// Add tickets to database
		// add the customer to the database
		// add transaction id table to the database
		// update the availability in the relative performance database
		//
		//
		//
		System.out.println("Your tickets have been processed. We look forward to seeing you soon. Thank you.");
		mainMenu();
	}

	public void ClearBasket() {
		if (basket.getNoOfTotalTickets() >= 1) {
			System.out.println("Are you sure you wish to clear your basket?");
			System.out.println(formatter());
			System.out.println("1 - Yes, clear my basket");
			System.out.println("2 - No, take me back");
			System.out.println(formatter());

			switch (in.getNumber("")) {
			case 1:
				basket.clearBasket();
				System.out.println("Your basket has been cleared.");
				mainMenu();
				break;
			case 2:
				viewBasket();
				break;

			}
		} else {
			System.out.println("There are currently no tickets in your basket");
			viewBasket();
		}
	}

}