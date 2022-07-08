package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserTest {

	User user;

	@Test
	void constuctorTest() {
		User user = new User("fName", "lName", "Blyth", "Newcastle", "NE233DW", 101, "yyy@gmail.com",
				"1234 5678, 9012 3456", "Student");
		assertEquals("fName", user.getFirstName());
		assertEquals("lName", user.getLastName());
		assertEquals("Newcastle", user.getCity());
		assertEquals("Blyth", user.getStreetName());
		assertEquals("NE233DW", user.getPostcode());
		assertEquals(101, user.getUserReferenceID());
		assertEquals("yyy@gmail.com", user.getEmail());
		assertEquals("1234 5678, 9012 3456", user.getCcNumber());
		assertEquals("Student", user.getConcessionID());
		assertNotNull(user);

	}

	@Test
	void createEmployeeTest() {
		User newUser = new User("Dave", "M", "123 Avenue", "Cork", "DD1 DD1", "ggg@gmail.com");
		assertEquals("Dave", newUser.getFirstName());
		assertEquals("M", newUser.getLastName());
		assertEquals("Cork", newUser.getCity());
		assertEquals("123 Avenue", newUser.getStreetName());
		assertEquals("DD1 DD1", newUser.getPostcode());
		assertEquals("ggg@gmail.com", newUser.getEmail());

	}
}
