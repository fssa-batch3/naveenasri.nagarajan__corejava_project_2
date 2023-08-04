package dynamicDesign.model;

public class User {

	private String email;
	private String username;
	private String password;
	private String phonenumber;
	private String type;

	public User(String email, String username, String password, String phonenumber, String type) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.type = type;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", phonenumber="
				+ phonenumber + ", type=" + type + "]";
	}

}