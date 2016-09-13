package mum.edu.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
@Entity
public class Beneficiary {
	
	@Id
	@GeneratedValue
	private int beneficiaryId;
	private String beneficiaryName;
	private String beneficiaryDescription;
	@Lob byte[] image;
	@ManyToMany(mappedBy="beneficiaries",fetch=FetchType.EAGER)
	@Basic(fetch=FetchType.EAGER)
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
	/*@Override
	public String toString() {
		return "Beneficiary [beneficiaryId=" + beneficiaryId + ", beneficiaryName=" + beneficiaryName
				+ ", beneficiaryDescription=" + beneficiaryDescription + "]";
	}*/
}
