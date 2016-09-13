package mum.edu.cs544.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import mum.edu.cs544.config.Utility;
import mum.edu.cs544.domain.Address;
import mum.edu.cs544.domain.User;

public class UserDAO implements IUserDAO {

	public void create(User user) {
		EntityManager em = Utility.getEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(user);
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
	}

	public boolean authenticateUser(User user) {
		EntityManager em = Utility.getEntityManager();
		EntityTransaction tx = null;
		User u = new User();
		
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM User u where u.uID = :userId");
			query.setParameter("userId",user.getuID());
			u = (User) query.getSingleResult();
			if(u!=null){
				if(u.getPassword().equals(user.getPassword()))
				{
					return true;
				}
			}
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
		
		return false;
	}

	public void saveNewAddress(Address address) {
		EntityManager em = Utility.getEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(address);
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
		
	}

	public List<User> getAllUser() {
		EntityManager em = Utility.getEntityManager();
		EntityTransaction tx = null;
		List<User> ulist = new ArrayList<User>();
		
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM User u");
			ulist = query.getResultList();
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
		
		return ulist;
	}

	


}
