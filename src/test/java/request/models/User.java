package request.models;


public class User {
  
	private String id;
		
	private String name; 
	
	private String Age;
	
	private String city;
	
	private Info info;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getAge() {
		return Age;
	}
	
	public void setAge(String age) {
		this.Age=age;
	}
	
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	
	public boolean equals(Object other){
		
	     if (this == other) return true;
	     
	     if (!(other instanceof User)) return false;
	     
	     final User that = (User) other;
	     
	     return this.id.equals(that.id);
	}

	public int hashCode(){

		return this.getId().hashCode();
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
}
