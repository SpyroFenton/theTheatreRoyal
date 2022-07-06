package model;

import java.util.ArrayList;

public abstract class ShowType {
	private String showName;
	private String showType;
	private int duration;
	private int startTime;
	private String language;
	private int showProductionID;
	private Boolean liveAccompaniment;
	private String description;
	private Double stallPrice;
	private Double circlePrice;
	private ArrayList<Performer> performers;

	public void buildShow(String showName, String showType, int duration, int startTime, String language,
			int showProductionID, Boolean liveAccompaniment, String description, Double stallPrice,
			Double circlePrice) {
		this.showName = showName;
		this.showType = showType;
		this.duration = duration;
		this.startTime = startTime;
		this.language = language;
		this.showProductionID = showProductionID;
		this.liveAccompaniment = liveAccompaniment;
		this.description = description;
		this.stallPrice = stallPrice;
		this.circlePrice = circlePrice;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getShowProductionID() {
		return showProductionID;
	}

	public void setShowProductionID(int showProductionID) {
		this.showProductionID = showProductionID;
	}

	public Boolean getLiveAccompaniment() {
		return liveAccompaniment;
	}

	public void setLiveAccompaniment(Boolean liveAccompaniment) {
		this.liveAccompaniment = liveAccompaniment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getStallPrice() {
		return stallPrice;
	}

	public void setStallPrice(Double stallPrice) {
		this.stallPrice = stallPrice;
	}

	public Double getCirclePrice() {
		return circlePrice;
	}

	public void setCirclePrice(Double circlePrice) {
		this.circlePrice = circlePrice;
	}

	public ArrayList<Performer> getPerformers() {
		return performers;
	}

	public void setPerformers(ArrayList<Performer> performers) {
		this.performers = performers;
	}
	
	
	
	
}

