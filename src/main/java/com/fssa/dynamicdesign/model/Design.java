package com.fssa.dynamicdesign.model;

public class Design {
	
	private String designName;
	private String designUrl;
	private double price;
	private int noOfRooms;
	private boolean isDeleted;
	private String coverPhoto;
	private String architectName;
	private String phoneNumber;
	private String architectEmail;
	private int experience;
	private int designId;
	private int architectID;
	private Architect architect;
	

	
	//constructors
	public Design() {
		super();
	}
	
	// create Design 
	public Design(String designName, String designUrl, double price, int noOfRooms, int architectID) {
		super();
		this.designName = designName;
		this.designUrl = designUrl;
		this.price = price;
		this.noOfRooms = noOfRooms;
		this.architectID = architectID;
	}


	//List
	public Design(String designName, String designUrl, double price, int noOfRooms, boolean isDeleted,
			String coverPhoto, String architectName, String phoneNumber, String architectEmail, int experience,
			int designId, int architectID) {
		super();
		this.designName = designName;
		this.designUrl = designUrl;
		this.price = price;
		this.noOfRooms = noOfRooms;
		this.isDeleted = isDeleted;
		this.coverPhoto = coverPhoto;
		this.architectName = architectName;
		this.phoneNumber = phoneNumber;
		this.architectEmail = architectEmail;
		this.experience = experience;
		this.designId = designId;
		this.architectID = architectID;
	}


	
	//Update and Delete

	public Design(int designId,String designName, String designUrl, double price, int noOfRooms) {
		super();
		this.designId = designId;
		this.designName = designName;
		this.designUrl = designUrl;
		this.price = price;
		this.noOfRooms = noOfRooms;
	}





	// getters and setters
	public String getDesignName() {
		return designName;
	}


	public void setDesignName(String designName) {
		this.designName = designName;
	}


	public String getDesignUrl() {
		return designUrl;
	}


	public void setDesignUrl(String designUrl) {
		this.designUrl = designUrl;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getNoOfRooms() {
		return noOfRooms;
	}


	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public String getCoverPhoto() {
		return coverPhoto;
	}


	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}


	public String getArchitectName() {
		return architectName;
	}


	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getArchitectEmail() {
		return architectEmail;
	}


	public void setArchitectEmail(String architectEmail) {
		this.architectEmail = architectEmail;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public int getDesignId() {
		return designId;
	}


	public void setDesignId(int designId) {
		this.designId = designId;
	}


	public int getArchitectId() {
		return architectID;
	}


	public void setArchitectId(int architectID) {
		this.architectID = architectID;
	}


	public Architect getArchitect() {
		return architect;
	}


	public void setArchitect(Architect architect) {
		this.architect = architect;
	}


	@Override
	public String toString() {
		return "NewDesign [designName=" + designName + ", designUrl=" + designUrl + ", price=" + price + ", noOfRooms="
				+ noOfRooms + ", isDeleted=" + isDeleted + ", coverPhoto=" + coverPhoto + ", architectName="
				+ architectName + ", phoneNumber=" + phoneNumber + ", architectEmail=" + architectEmail
				+ ", experience=" + experience + ", designId=" + designId + ", architectId=" + architectID
				+ ", architect=" + architect + "]";
	}
}
