package com.hexaware.flightbackend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.flightbackend.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	@Query("FROM Flight WHERE source=:source AND destination=:destination AND travelDate=:travelDate")
	List<Flight> findByCondition(String source, String destination, LocalDate travelDate);

}
