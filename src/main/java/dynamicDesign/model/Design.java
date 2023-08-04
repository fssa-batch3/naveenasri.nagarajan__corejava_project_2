package dynamicDesign.model;

public class Design {
	private String designName;
	private String designUrl;
	private double price;
	private String email;
	private int noOfRoom;
	
	
	
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
	public Design(String designname, String designurl, double price, String email, int noofroom) {
		super();
		this.designName = designname;
		this.designUrl = designurl;
		this.price = price;
		this.email = email;
		this.noOfRoom = noofroom;
	}
	@Override
	public String toString() {
		return "Design [designname=" + designName + ", designurl=" + designUrl + ", price=" + price + ", email=" + email
				+ ", noofroom=" + noOfRoom + "]";
	}
	
	
	
}
