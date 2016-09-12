package mum.edu.cs544.domain;

public class Task {
	private int taskId;
	private String description;
	private double timeframeToCompleteInDays;
	private String taskStatus;
	byte[] image;
	private String resourceRequired;
	private User user;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTimeframeToCompleteInDays() {
		return timeframeToCompleteInDays;
	}
	public void setTimeframeToCompleteInDays(double timeframeToCompleteInDays) {
		this.timeframeToCompleteInDays = timeframeToCompleteInDays;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getResourceRequired() {
		return resourceRequired;
	}
	public void setResourceRequired(String resourceRequired) {
		this.resourceRequired = resourceRequired;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", timeframeToCompleteInDays="
				+ timeframeToCompleteInDays + ", taskStatus=" + taskStatus + ", resourceRequired=" + resourceRequired
				+ ", user=" + user + "]";
	}
	
}
