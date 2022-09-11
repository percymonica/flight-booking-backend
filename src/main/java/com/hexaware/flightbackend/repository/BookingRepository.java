package com.hexaware.flightbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.flightbackend.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
