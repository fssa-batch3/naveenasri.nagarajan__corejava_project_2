package com.fssa.dynamicdesign.model;

public class Booking {

	private int bookingId;
	private String designName;
	private String designUrl;
	private int ExpectedAmount;
	private int ExpectedMonths;
	private String message;
	private String status;
	private int architectId;
	private Architect architect;
	private int userId;
	private User user;
	private String date;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public int getExpectedAmount() {
		return ExpectedAmount;
	}

	public void setExpectedAmount(int expectedAmount) {
		ExpectedAmount = expectedAmount;
	}

	public int getExpectedMonths() {
		return ExpectedMonths;
	}

	public void setExpectedMonths(int expectedMonths) {
		ExpectedMonths = expectedMonths;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
