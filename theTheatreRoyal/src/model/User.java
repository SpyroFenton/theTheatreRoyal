package model;

import java.util.ArrayList;

public class User {
	
	//private Boolean isEmployee; (undecided)
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<User> employees = new ArrayList<>();
	private String firstName;
	private String lastName;
	private String streetName;
	private String city;
	private String postcode;
	private int userReferenceID;
	private String email;
	private String ccNumber;
	private String concessionID;
	
	/**
	 * Main constructor used for creating new members
	 * @param firstName
	 * @param lastName
	 * @param streetName
	 * @param city
	 * @param postcode
	 * @param userReferenceID
	 * @param email
	 * @param ccNumber
	 * @param concessionID
	 */
	public User(String firstName, String lastName, String streetName, String city, String postcode
			, int userReferenceID, String email, String ccNumber, String concessionID) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetName = streetName;
		this.city = city;
		this.postcode = postcode;
		this.userReferenceID = userReferenceID;
		this.email = email;
		this.ccNumber = ccNumber;
		this.concessionID = concessionID;
	
	}
	
	/**
	 * This is a overloaded constructor, used to generate a new Employee record
	 * @param firstName
	 * @param lastName
	 * @param streetName
	 * @param city
	 * @param postcode
	 * @param email
	 */
	
	public User(String firstName, String lastName,  String streetName, String city, String postcode,
			String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetName = streetName;
		this.city = city;
		this.postcode = postcode;
		this.email = email;
		
		
	} 

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUser(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<User> getEmployees() {
		return employees;
	}

	

	public void addEmployees(User newEmp) {
		employees.add(newEmp);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getUserReferenceID() {
		return userReferenceID;
	}

	public void setUserReferenceID(int userReferenceID) {
		this.userReferenceID = userReferenceID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getConcessionID() {
		return concessionID;
	}

	public void setConcessionID(String concessionID) {
		this.concessionID = concessionID;
	}

}
