package model;

public class User {
    
	private int userReferenceID;
	private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
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
    public User(int userReferenceID, String firstName, String lastName, String addressLine1, String addressLine2, String postcode
            , String email, String phoneNo, String ccNumber, boolean isEmployee) {
        
    	this.userReferenceID = userReferenceID;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
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
		return addressLine1;
	}

	public void setStreet(String street) {
		this.addressLine1 = street;
	}

	public String getCity() {
		return addressLine2;
	}

	public void setCity(String city) {
		this.addressLine2 = city;
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
   
