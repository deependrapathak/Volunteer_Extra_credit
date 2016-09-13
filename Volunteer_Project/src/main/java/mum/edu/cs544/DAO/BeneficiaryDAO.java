package mum.edu.cs544.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import mum.edu.cs544.config.Utility;
import mum.edu.cs544.domain.Beneficiary;



public class BeneficiaryDAO implements IBeneficiaryDAO{

	public void createBeneficiary(Beneficiary beneficiary) {
		EntityManager em = Utility.getEntityManager();
		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(beneficiary);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

	public List<Beneficiary> getAllBeneficiariesByProjectId(int projectId) {
		EntityManager em = Utility.getEntityManager();
		EntityTransaction tx = null;
		List<Beneficiary> beneficiaries = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("SELECT p.beneficiaries FROM Project p WHERE p.projectId = :projectId");
			query.setParameter("projectId",projectId);
			beneficiaries = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return beneficiaries;
	}
	
}
