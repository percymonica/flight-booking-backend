package com.hexaware.flightbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.flightbackend.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
