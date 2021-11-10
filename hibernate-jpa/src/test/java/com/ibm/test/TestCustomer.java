package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.ibm.entity.Customer;
import com.ibm.entity.Person;

public class TestCustomer {
	
	@Test
	public void testSaveCustomer() {
		//factory - associated with many operations
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		
		//create entity - creates the connection with first-jpa
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction(); //commit or roll back
		
		txn.begin();
		Customer c1 = new Customer();
		c1.setCustId(2);
		c1.setCustName("Shiva");
		c1.setCity("Kolkata");
		
		mgr.persist(c1); //CRUD operation insert into values 
		txn.commit(); //save
		
		mgr.close();//closing manager
		emf.close();//closing factory
	}
	
	@Test
	public void testGetPerson() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		
		Customer c = mgr.find(Customer.class, 1);
		System.out.println(c.getCustName() + "\t" + c.getCity());
		
		mgr.close();//closing manager
		emf.close();//closing factory
	}
	
	
	
}