package controller;

public class FrontEndController {
	private BackEndController bec;

	public FrontEndController() {
	}

	public static void main(String[] args) {

		BackEndController bec = new BackEndController();

		bec.mainMenu();

	}

}
