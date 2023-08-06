package dynamicDesign.model;

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



    public Architect(int architectID, String profilePhoto, String name, String gender, String phoneNumber,
            String address, String coverPhoto, String email, String password, String education, int experience,
            String degreeCertificate, String nATACertificate) {
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

    


    public Architect(String profilePhoto, String name, String gender, String phoneNumber, String address,
            String coverPhoto, String email, String password, String education, int experience,
            String degreeCertificate, String nATACertificate) {
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
        NATACertificate = nATACertificate;
    }




    public Architect(String email, String password) {
        this.email = email;
        this.password = password;
    }





    public void setArchitectID(int architectID) {
        this.architectID = architectID;
    }



    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }



    public void setName(String name) {
        this.name = name;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public void setEducation(String education) {
        this.education = education;
    }



    public void setExperience(int experience) {
        this.experience = experience;
    }



    public void setDegreeCertificate(String degreeCertificate) {
        this.degreeCertificate = degreeCertificate;
    }



    public void setNATACertificate(String nATACertificate) {
        this.NATACertificate = nATACertificate;
    }



    public int getArchitectID() {
        return architectID;
    }



    public String getProfilePhoto() {
        return profilePhoto;
    }



    public String getName() {
        return name;
    }



    public String getGender() {
        return gender;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public String getAddress() {
        return address;
    }



    public String getCoverPhoto() {
        return coverPhoto;
    }



    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }



    public String getEducation() {
        return education;
    }



    public int getExperience() {
        return experience;
    }



    public String getDegreeCertificate() {
        return degreeCertificate;
    }



    public String getNATACertificate() {
        return NATACertificate;
    }



    @Override
    public String toString() {
        return "Architect [architectID=" + architectID + ", profilePhoto=" + profilePhoto + ", name=" + name
                + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address=" + address + ", coverPhoto="
                + coverPhoto + ", email=" + email + ", password=" + password + ", education=" + education
                + ", experience=" + experience + ", degreeCertificate=" + degreeCertificate + ", NATACertificate="
                + NATACertificate + "]";
    }

    


}
