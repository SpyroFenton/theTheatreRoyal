package model;

public class User {
    
	private int userReferenceID;
	private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postcode;
    private String email;
    private String phoneNo;
    private String ccNo;
    private boolean isEmployee;
    
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
     */
    public User(int userReferenceID, String firstName, String lastName, String street, String city, String postcode
            , String email, String phoneNo, String ccNumber, boolean isEmployee) {
        
    	this.userReferenceID = userReferenceID;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.email = email;
        this.phoneNo = phoneNo;
        this.ccNo = ccNumber;
        this.isEmployee = isEmployee;
    
    }
    
    /**
     * generated getters and setters
     *
     */

	public int getUserReferenceID() {
		return userReferenceID;
	}

	public void setUserReferenceID(int userReferenceID) {
		this.userReferenceID = userReferenceID;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCcNumber() {
		return ccNo;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNo = ccNumber;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
    
    
}
   
