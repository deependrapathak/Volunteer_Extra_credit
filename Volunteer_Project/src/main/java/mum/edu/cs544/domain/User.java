package mum.edu.cs544.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
private int uID;
private String name;
private String email;
private String password;
private Address address;

public int getuID() {
	return uID;
}
public void setuID(int uID) {
	this.uID = uID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public List<Project> getProjects() {
	return projects;
}
public void setProjects(List<Project> projects) {
	this.projects = projects;
}
public List<Task> getTaskOffered() {
	return taskOffered;
}
public void setTaskOffered(List<Task> taskOffered) {
	this.taskOffered = taskOffered;
}
private Role role;
private List<Project> projects=new ArrayList<Project>();
private List<Task> taskOffered=new ArrayList<Task>();

@Override
public String toString() {
	return "User [uID=" + uID + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
			+ address + ", role=" + role + ", projects=" + projects + ", taskOffered=" + taskOffered + "]";
} 
}
