package com.ibm.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepository;
import com.ibm.repo.FlightRepositoryImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:appctx.xml")
public class TestFlight {
	
	@Autowired
	private FlightRepository repo;
	
	@Test
	public void testSaveFlight() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
//		FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		Flight f = new Flight();
		f.setCode(1001);
		f.setCarrier("Air India");
		f.setSource("Chennai");
		f.setDestiny("Mumbai");
//		System.out.println("Flight" +  f.getCarrier() + " , " + f.getSource() + " , " + f.getDestiny());
		repo.save(f);	
	}
	
	@Test
	public void testFetch() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
//		FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		Flight f = repo.fetch(1001);
		System.out.println(f.getCarrier() + " , " + f.getSource() + " , " + f.getDestiny());
	}
	
	@Test
	public void testFetchAll() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
//		FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		List<Flight> list = repo.fetchAll();
		for(Flight flight:list) {
			System.out.println(flight.getCode() +" "+ flight.getCarrier() +" "+ flight.getSource() +" "+ flight.getDestiny());
		}
	}
	
	@Test
	public void testFetchByCarrier() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
//		FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		List<Flight> list = repo.fetchByCarrier("Jet Airways");
		for(Flight flight:list) {
			System.out.println(flight.getCode() +" "+ flight.getSource() +" "+ flight.getDestiny());
		}
	}
	
	@Test
	public void testFetchByRoute() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
//		FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		List<Flight> flight = repo.fetchByRoute("Cochin", "Delhi");
		flight.forEach(System.out::println);
//		for(Flight flight: flights)
//			System.out.println(flight.getCode() + " " + flight.getCarrier() + " " + flight.getSource() + " " + flight.getDestiny());
	}

	@Test
	public void testUpdateFlight() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
//		FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		Flight f = new Flight();
		f.setCode(7896);
		f.setCarrier("Boeing");
		f.setSource("Delhi");
		f.setDestiny("Paris");
		
		repo.update(f);
	}
	
	@Test
	public void testRemove() {
		repo.remove(121);
	}
}
