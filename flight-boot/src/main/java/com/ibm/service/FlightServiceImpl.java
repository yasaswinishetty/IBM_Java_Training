package com.ibm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository repo;

	@Transactional
	@Override
	public void save(Flight f) {
		repo.save(f);
	}

	@Override
	public Flight fetch(int code) {
		return repo.findById(code).get();	}

	@Override
	public List<Flight> list() {
		return repo.findAll();
	}
	
	@Override
	public void delete(int code) {
		repo.deleteById(code);
	}

	@Override
	public List<Flight> byCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> byRoute(String source, String destiny) {
		return repo.findByRoute(source, destiny);
	}
}
