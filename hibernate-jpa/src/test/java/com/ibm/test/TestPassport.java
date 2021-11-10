package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.ibm.entity.Passport;
import com.ibm.entity.Person;

public class TestPassport {
	
	@Test
	public void testSavePerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		
		Person p = new Person();
		p.setName("Jessy");
		p.setAge(49);
		
		mgr.persist(p);
		txn.commit();
		
		mgr.close();
		emf.close();	
	}
	
	@Test
	public void testGetPerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		
		Person p = mgr.find(Person.class, 1);
		System.out.println(p.getName() + "\t" + p.getAge());
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testSavePassport() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		
		Passport pp = new Passport();
		pp.setPassportNo(1234567891);
		pp.setCountry("America");
		
		Person p = mgr.find(Person.class,1);
		pp.setCitizen(p);
		
		mgr.persist(pp);
		txn.commit();
		
		mgr.close();
		emf.close();
	}

}
