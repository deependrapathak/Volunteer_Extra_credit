package mum.edu.cs544.DAO;

import java.util.List;

import mum.edu.cs544.domain.Beneficiary;


public interface IBeneficiaryDAO {
	void createBeneficiary(Beneficiary beneficiary);
	List<Beneficiary> getAllBeneficiariesByProjectId(int projectId);
}
