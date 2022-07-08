package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTest {

	@Test
	void test() {
	Ticket ticket1 = new Ticket(1, "1", "Queen", 10.00, "20:00", "2022-10-10", "circle", "Student", "post");
	assertEquals(10.00, ticket1.getPrice());
	ticket1.applyConcession();
	assertEquals(7.50, ticket1.getPrice());
	}

}
