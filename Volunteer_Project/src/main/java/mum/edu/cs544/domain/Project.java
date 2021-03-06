package mum.edu.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Project {
	@Id
	@GeneratedValue
	private int projectId;
	private String projectname;
	private String description;
	private String location;
	private String startDate;
	private String endDate;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="ProjectTask",joinColumns=@JoinColumn(name="pr_ID"),inverseJoinColumns=@JoinColumn(name="ts_ID"))
	@Basic(fetch=FetchType.EAGER)
	private List<Task> tasks = new ArrayList<Task>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_pr",joinColumns=@JoinColumn(name="pr_id"),inverseJoinColumns=@JoinColumn(name="us_id"))
	@Basic(fetch=FetchType.EAGER)
	private List<User> users = new ArrayList<User>();
	private String projectStatus;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PR_BNF",joinColumns=@JoinColumn(name="pr_id"),inverseJoinColumns=@JoinColumn(name="bf_id"))
	@Basic(fetch=FetchType.EAGER)
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectname=" + projectname + ", description=" + description
				+ ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", projectStatus=" + projectStatus + "]";
	}
	
}
