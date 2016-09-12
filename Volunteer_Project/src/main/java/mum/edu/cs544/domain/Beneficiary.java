package mum.edu.cs544.domain;

import java.util.ArrayList;
import java.util.List;

public class Beneficiary {
	private int beneficiaryId;
	private String beneficiaryName;
	private String beneficiaryDescription;
	byte[] image;
	private List<Project> projects = new ArrayList<Project>();
	public int getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryDescription() {
		return beneficiaryDescription;
	}
	public void setBeneficiaryDescription(String beneficiaryDescription) {
		this.beneficiaryDescription = beneficiaryDescription;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
