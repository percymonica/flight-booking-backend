package com.hexaware.flightbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.flightbackend.entity.Ticket;
import com.hexaware.flightbackend.entity.User;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	List<Ticket> findByUser(User user);

}
