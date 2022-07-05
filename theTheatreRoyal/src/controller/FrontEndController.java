package controller;

import util.InputReader;

public class FrontEndController {
	
	InputReader read = new InputReader();
	private String choice = null;


	public void start() {

		System.out.println("Welcome. Please choose either: Browse, search, date");
		
		while (choice == null) {
			String choice = read.getInputString();

			if (choice.equalsIgnoreCase("Browse")) {
				System.out.println("Browsing all shows");
				choice = null;
				
			}

			else if (choice.equalsIgnoreCase("Search")) {
				System.out.println("Search for show");
				choice = null;

			}

			else if (choice.equalsIgnoreCase("date")) {
				System.out.println("Search by date");
				choice = null;
				
				
			} else if (choice.equalsIgnoreCase("exit")) {
				System.out.println("Exiting");
				break;
			}

			else {
				System.out.println("Invalid choice");
				choice = null;
			}
		}
	}
}
