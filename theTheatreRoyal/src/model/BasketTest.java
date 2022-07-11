package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasketTest {

	Basket basket = new Basket();
	
	@Test
	void basketTotalAndClearBasketTest() {
		Ticket ticket1 = new Ticket(1, "1", "Queen", 10.00, "20:00", "2022-10-10", "circle", "Student", "post");
		Ticket ticket2 = new Ticket(1, "1", "Queen", 5.01, "20:00", "2022-10-10", "circle", "Adult", "post");
		basket.addTicket(ticket1);
		basket.addTicket(ticket2);
		assertEquals(15.01, basket.getBasketTotal());
		Ticket ticket3 = new Ticket(2, "2", "Adele", 19.03, "19:30", "2022-10-10", "stalls", "Adult", "collection");
		basket.addTicket(ticket3);
		assertEquals(34.04, basket.getBasketTotal());
		basket.clearBasket();
		assertEquals(0, basket.getNoOfTotalTickets());
		assertEquals(0.00, basket.getBasketTotal());
	}
	
	
}