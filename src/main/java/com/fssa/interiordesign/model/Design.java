package com.fssa.interiordesign.model;

public class Design {
	private Integer designId;
	private String designName;
	private String designUrl;
	private double price;
	private String email;
	private int noOfRoom;
	private boolean isDeleted;

	public Design(Integer designId, String designName, String designUrl, double price, String email, int noOfRoom,
			boolean isDeleted) {
		super();
		this.designId = designId;
		this.designName = designName;
		this.designUrl = designUrl;
		this.price = price;
		this.email = email;
		this.noOfRoom = noOfRoom;
		this.isDeleted = isDeleted;
	}

	public Design(Integer designId, String designName, String designUrl, double price, String email, int noOfRoom) {
		super();
		this.designId = designId;
		this.designName = designName;
		this.designUrl = designUrl;
		this.price = price;
		this.email = email;
		this.noOfRoom = noOfRoom;
	}

	public Design(String designName, String designUrl, double price, String email, int noOfRoom) {
		super();
		this.designName = designName;
		this.designUrl = designUrl;
		this.price = price;
		this.email = email;
		this.noOfRoom = noOfRoom;
	}

	public Integer getDesignId() {
		return designId;
	}

	public void setDesignId(Integer designId) {
		this.designId = designId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNoOfRoom() {
		return noOfRoom;
	}

	public void setNoOfRoom(int noOfRoom) {
		this.noOfRoom = noOfRoom;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Design [designId=" + designId + ", designName=" + designName + ", designUrl=" + designUrl + ", price="
				+ price + ", email=" + email + ", noOfRoom=" + noOfRoom + ", isDeleted=" + isDeleted + "]";
	}

}