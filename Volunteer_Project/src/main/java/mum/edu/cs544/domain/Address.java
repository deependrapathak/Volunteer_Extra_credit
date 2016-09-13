package mum.edu.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private int aID;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public int getaID() {
		return aID;
	}
	public void setaI(int aID) {
		this.aID = aID;
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
	/*@Override
	public String toString() {
		return "Address [aI=" + aID + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}*/

}
