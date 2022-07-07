package model;

public class Ticket {
	
	private int transactionID;
	private String performanceID;
	private String showName;
	private String location;
	private Double price;
	private String startTime;
	private String date;
	private String seatType;
	private String concession; 

	public Ticket(int transactionID, String performanceID, String showName, Double price, String startTime, String date,
			String seatType, String concession) {

		this.transactionID = transactionID;
		this.performanceID = performanceID;
		this.showName = showName;
		location = "Theater Royal";
		this.price = price;
		this.startTime = startTime;
		this.date = date;
		this.seatType = seatType;
		this.concession = concession;

	}

	

	public int getTransactionID() {
		return transactionID;
	}


	public String getPerformanceID() {
		return performanceID;
	}


	public String getShowName() {
		return showName;
	}


	public Double getPrice() {
		return price;
	}


	public String getStartTime() {
		return startTime;
	}



	public String getDate() {
		return date;
	}


	public String getSeatType() {
		return seatType;
	}



	public String getConcession() {
		return concession;
	}

	public void setCircle(String isCircle) {
		if (isCircle.equalsIgnoreCase("circle")) {
			this.seatType = "Circle seat";
		}
		this.seatType = "Stall seat";
	}

	public void setConcession(String concession) {
		this.concession = concession;
	}
	
	

}
