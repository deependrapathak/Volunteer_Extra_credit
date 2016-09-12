package mum.edu.cs544.domain;

public class Address {
	private int aI;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public int getaI() {
		return aI;
	}
	public void setaI(int aI) {
		this.aI = aI;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [aI=" + aI + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}

}
