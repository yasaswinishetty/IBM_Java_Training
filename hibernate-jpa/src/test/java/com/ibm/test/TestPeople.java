package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import com.ibm.entity.Person;

public class TestPeople {

	@Test
	public void testSavePerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Person p1 = new Person();
		p1.setName("Yashu");
		p1.setAge(21);
		
		mgr.persist(p1);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testGetPerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		
		Person p = mgr.find(Person.class, 2);
		System.out.println(p.getName() + "\t" + p.getAge());
		
		mgr.remove(p);
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testDeletePerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();		
		txn.begin();
		
		Person p = mgr.find(Person.class, 11);
		mgr.remove(p);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testUpdatePerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();		
		txn.begin();
		
		Person p =mgr.find(Person.class, 13);
		p.setAge(42);
		p.setName("Michael");
		
		mgr.merge(p);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
}
