package model;

import java.util.ArrayList;

public class Checkout {
	
	private ArrayList<Ticket> tickets;
	private Double basketTotal = 0.00;
	
	public Checkout() {
		
		tickets = new ArrayList<>();
		
	}

	public Double getBasketTotal() {
		return basketTotal;
	}

	/*
	 * Used to keep adding to the basket total
	 */
	public void setBasketTotal(Double basket) {
		basketTotal += basket;
	}
	
	public int getTicketSize() {
		return tickets.size();
	}

	public void addTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	/**
	 * ticket confirmation print statement. Will need adjusted to suit final design
	 */
	public void printConfirmation() {
		System.out.println("We can confirm you have purchsed " + tickets.size() +
				" for a total of £" + basketTotal.toString());
	}
}
