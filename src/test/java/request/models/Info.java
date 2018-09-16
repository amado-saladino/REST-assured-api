package request.models;


public class Info {

    private String email;

    private String phone;
	
    private String address;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean equals(Object other){

        if (this == other) return true;

        if (!(other instanceof Info)) return false;

        final Info that = (Info) other;

        return this.email.equals(that.email);
    }

    public int hashCode(){

        return this.email.hashCode();
    }

}
