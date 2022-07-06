package model;
//package model;
//
//import java.util.ArrayList;
//
//public abstract class ShowType {
//	private String showName;
//	private String showType;
//	private int duration;
//	private int startTime;
//	private String language;
//	private int showProductionID;
//	private Boolean liveAccompaniment;
//	private String description;
//	private Double stallPrice;
//	private Double circlePrice;
//	private ArrayList<Performer> performers;
//	private int stallsAvailable;
//	private int circleAvailable;
//
//	/**
//	 * buildShow method is passed into all subclasses constructor 
//	 * as this allows code to not have to be repeated in each subclass
//	 */
//	public ShowType(String showName, String showType, int duration, int startTime, String language,
//			int showProductionID, Boolean liveAccompaniment, String description, Double stallPrice,
//			Double circlePrice) {
//		this.showName = showName;
//		this.showType = showType;
//		this.startTime = startTime;
//		this.duration = duration;
//		this.language = language;
//		this.showProductionID = showProductionID;
//		this.liveAccompaniment = liveAccompaniment;
//		this.description = description;
//		this.stallPrice = stallPrice;
//		this.circlePrice = circlePrice;
//		performers = new ArrayList<Performer>();
//		/**
//		 * amount of seats available are hard-coded. Unless specification changes 
//		 * this will not change either.
//		 */
//		stallsAvailable = 120; 
//		circleAvailable = 80;
//	}
//
//	/**
//	 * 
//	 * generated getters and setters
//	 */
//	
//	public String getShowName() {
//		return showName;
//	}
//
//	public void setShowName(String showName) {
//		this.showName = showName;
//	}
//
//	public String getShowType() {
//		return showType;
//	}
//
//	public void setShowType(String showType) {
//		this.showType = showType;
//	}
//
//	public int getDuration() {
//		return duration;
//	}
//
//	public void setDuration(int duration) {
//		this.duration = duration;
//	}
//
//	public int getStartTime() {
//		return startTime;
//	}
//
//	public void setStartTime(int startTime) {
//		this.startTime = startTime;
//	}
//
//	public String getLanguage() {
//		return language;
//	}
//
//	public void setLanguage(String language) {
//		this.language = language;
//	}
//
//	public int getShowProductionID() {
//		return showProductionID;
//	}
//
//	public void setShowProductionID(int showProductionID) {
//		this.showProductionID = showProductionID;
//	}
//
//	public Boolean getLiveAccompaniment() {
//		return liveAccompaniment;
//	}
//
//	public void setLiveAccompaniment(Boolean liveAccompaniment) {
//		this.liveAccompaniment = liveAccompaniment;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	/**
//	 * 
//	 * methods for the seats for each concert including
//	 * getters for seeing what seats are available, and 
//	 * setters which take an int parameter that represents the amount
//	 * of tickets a customer might purchase.
//	 */
//	
//	
//	public int getTotalSeatsAvailable() {
//		int total = stallsAvailable + circleAvailable;
//		return total;
//	}
//
//	public int getCircleSeatsAvailable() {
//		return circleAvailable;
//	}
//	
//	public int getStallsSeatsAvailable() {
//		return stallsAvailable;
//	}
//	
//	public void setStallsAvailable(int purchase) {
//		stallsAvailable = stallsAvailable - purchase;
//	}
//	
//	public void setCircleAvailable(int purchase) {
//		circleAvailable = circleAvailable - purchase;
//	}
//	
//	public Double getStallPrice() {
//		return stallPrice;
//	}
//
//	public void setStallPrice(Double stallPrice) {
//		this.stallPrice = stallPrice;
//	}
//
//	public Double getCirclePrice() {
//		return circlePrice;
//	}
//
//	public void setCirclePrice(Double circlePrice) {
//		this.circlePrice = circlePrice;
//	}
//
//	/**
//	 * methods for ArrayList performers
//	 * getAllPerformers, addPerformer, getMusicPerformers, getRegularPerformers
//	 * 
//	 */
//	
//	public ArrayList<Performer> getAllPerformers() {
//		return performers;
//	}
//	
//	public void addPerformer(Performer performer) {
//		performers.add(performer);
//	}
//	
//	public ArrayList<Performer> getMusicPerformers() {
//		ArrayList<Performer> musicPerformers = new ArrayList<Performer>();
//		for (int i = 0; i < performers.size(); i++) {
//			if (performers.get(i).isMusic()) {
//				musicPerformers.add(performers.get(i));
//			}
//		}
//		
//		return musicPerformers;
//	}
//	
//	public ArrayList<Performer> getRegularPerformers() {
//		ArrayList<Performer> regularPerformers = new ArrayList<Performer>();
//		for (int i = 0; i < performers.size(); i++) {
//			if (performers.get(i).isMusic()) {
//				regularPerformers.add(performers.get(i));
//			}
//		}
//		
//		return regularPerformers;
//	}
//	
//	
//}
//
