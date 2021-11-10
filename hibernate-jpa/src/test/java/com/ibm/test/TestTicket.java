package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

public class TestTicket {

	@Test
	public void testSavePassenger() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		
		Passenger p = new Passenger();
		p.setName("Yashu");
		p.setAge(21);
		
		mgr.persist(p);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testGetPassenger() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		
		Passenger p = mgr.find(Passenger.class, 1);
		System.out.println(p.getName() + "\t" + p.getAge());
		
		mgr.close();
		emf.close();;
		
	}
	
	@Test
	public void testSaveTicket() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		
		Ticket tt = new Ticket();
		tt.setPnr(1788698201);
		tt.setAmount(945);
		
		Passenger p = mgr.find(Passenger.class, 1);
		tt.setPassenger(p);
		
		mgr.persist(tt);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
}
