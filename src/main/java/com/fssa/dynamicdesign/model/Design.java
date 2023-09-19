package com.fssa.dynamicdesign.model;

import java.util.List;

public class Design {

	private String designName;
	private List<String> designUrls; // Use a List to store design URLs
	private String style;
	private double pricePerSqFt;
	private int squareFeet;
	private String category;
	private String floorPlan;
	private int timeRequired;
	private String bio;
	private String brief;
	private boolean isDeleted;
	private int designId;
	private int architectId;
	private Architect architect;
	private long uniqueId;

	// Constructors, getters, setters, and other methods here...

	public Design() {
		super();
	}

	public String getDesignName() {
		return designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public List<String> getDesignUrls() {
		return designUrls;
	}

	public void setDesignUrls(List<String> designUrls) {
		this.designUrls = designUrls;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getPricePerSqFt() {
		return pricePerSqFt;
	}

	public void setPricePerSqFt(double pricePerSqFt) {
		this.pricePerSqFt = pricePerSqFt;
	}

	public int getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFloorPlan() {
		return floorPlan;
	}

	public void setFloorPlan(String floorPlan) {
		this.floorPlan = floorPlan;
	}

	public int getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getDesignId() {
		return designId;
	}

	public void setDesignId(int designId) {
		this.designId = designId;
	}

	public int getArchitectId() {
		return architectId;
	}

	public void setArchitectId(int architectId) {
		this.architectId = architectId;
	}

	public Architect getArchitect() {
		return architect;
	}

	public void setArchitect(Architect architect) {
		this.architect = architect;
	}

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}
}
