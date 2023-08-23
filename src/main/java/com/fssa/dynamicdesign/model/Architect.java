package com.fssa.dynamicdesign.model;

public class Architect {
	private int architectID;
	private String profilePhoto;
	private String name;
	private String gender;
	private String phoneNumber;
	private String address;
	private String coverPhoto;
	private String email;
	private String password;
	private String education;
	private int experience;
	private String degreeCertificate;
	private String NATACertificate;
	private boolean isDeleted;
	
	

	public Architect() {
		super();
	}

	public Architect(int architectID, String profilePhoto, String name, String gender, String phoneNumber,
			String address, String coverPhoto, String email, String password, String education, int experience,
			String degreeCertificate, String nATACertificate, boolean isDeleted) {
		super();
		this.architectID = architectID;
		this.profilePhoto = profilePhoto;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.coverPhoto = coverPhoto;
		this.email = email;
		this.password = password;
		this.education = education;
		this.experience = experience;
		this.degreeCertificate = degreeCertificate;
		this.NATACertificate = nATACertificate;
		this.isDeleted = isDeleted;
	}

	public Architect(int architectID, String profilePhoto, String name, String gender, String phoneNumber,
			String address, String coverPhoto, String email, String password, String education, int experience,
			String degreeCertificate, String nATACertificate) {
		super();
		this.architectID = architectID;
		this.profilePhoto = profilePhoto;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.coverPhoto = coverPhoto;
		this.email = email;
		this.password = password;
		this.education = education;
		this.experience = experience;
		this.degreeCertificate = degreeCertificate;
		this.NATACertificate = nATACertificate;
	}
	
	public Architect( String profilePhoto, String name, String gender, String phoneNumber,
			String address, String coverPhoto, String email, String password, String education, int experience,
			String degreeCertificate, String nATACertificate) {
		super();
		this.profilePhoto = profilePhoto;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.coverPhoto = coverPhoto;
		this.email = email;
		this.password = password;
		this.education = education;
		this.experience = experience;
		this.degreeCertificate = degreeCertificate;
		this.NATACertificate = nATACertificate;
	}
	
	public Architect(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Architect(String email, boolean isDeleted) {
		super();
		this.email = email;
		this.isDeleted = isDeleted;
	}
	
	public int getArchitectID() {
		return architectID;
	}

	public void setArchitectID(int architectID) {
		this.architectID = architectID;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDegreeCertificate() {
		return degreeCertificate;
	}

	public void setDegreeCertificate(String degreeCertificate) {
		this.degreeCertificate = degreeCertificate;
	}

	public String getNATACertificate() {
		return NATACertificate;
	}

	public void setNATACertificate(String nATACertificate) {
		this.NATACertificate = nATACertificate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Architect [architectID=" + architectID + ", profilePhoto=" + profilePhoto + ", name=" + name
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address=" + address + ", coverPhoto="
				+ coverPhoto + ", email=" + email + ", password=" + password + ", education=" + education
				+ ", experience=" + experience + ", degreeCertificate=" + degreeCertificate + ", NATACertificate="
				+ NATACertificate + ", isDeleted=" + isDeleted + "]";
	}

}
