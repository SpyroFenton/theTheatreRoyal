package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTest {

	@Test
	void Concessionstest() {
	Ticket ticket1 = new Ticket(1, "1", "Queen", 10.00, "20:00", "2022-10-10", "circle");
	assertEquals(10.00, ticket1.getPrice());
	ticket1.applyConcession("Student");
	assertEquals(7.50, ticket1.getPrice());
	}

}
