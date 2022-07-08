package model;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Ticket> tickets;
    private Double basketTotal;
    
    public Basket() {
        tickets = new ArrayList<>();
        basketTotal = 0.00;
    }
    
    /**
     * Basket methods
     */
     
 // clears the basket completely
    // we should never have to reset the basket without also resetting the tickets ArrayList
    public void clearBasket() {
        tickets = new ArrayList<Ticket>();
        basketTotal = 0.00;
    }
    
    public double getBasketTotal() {
    	double t = 0.00;
    	for (int i = 0; i < tickets.size(); i++) {	
    		t = t + tickets.get(i).getPrice();
    	}
    	basketTotal = t;
    	return basketTotal;
    }
    
    /**
     * 
     * Ticket methods.
     * Get total tickets in ArrayList
     * Add tickets to ArrayList.
     * PrintAllTickets method which also clears the basket.
     */
    public int getNoOfTotalTickets() {
        return tickets.size();
    }
    
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    
    /**
     * print all tickets
     */
    public void printAllTickets() {
    	int t = 0;
    	for (Ticket ticket : tickets) {
    		System.out.println("Printing: Ticket " + t);
    		ticket.printTicket();
    		t++;
    	}
    	System.out.println("All tickets have been printed and stored to your Customer ID.");
    	System.out.println("Thank you and we look forward to seeing you!");
    	clearBasket();
    }
}