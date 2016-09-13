package mum.edu.cs544.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {
	private static final EntityManagerFactory emf;
	static{
		try{
			emf=Persistence.createEntityManagerFactory("Volunteer_db");
		}
		catch(Throwable ex){
			throw new ExceptionInInitializerError();
		}
	}
	public static EntityManager getEntityManager(){
		EntityManager em=emf.createEntityManager();
		return em;
	}

}
