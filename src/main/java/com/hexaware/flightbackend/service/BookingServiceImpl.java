package com.hexaware.flightbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.flightbackend.entity.Passenger;
import com.hexaware.flightbackend.entity.Ticket;
import com.hexaware.flightbackend.entity.User;
import com.hexaware.flightbackend.service.BookingService;
import com.hexaware.flightbackend.entity.Booking;
import com.hexaware.flightbackend.repository.BookingRepository;
import com.hexaware.flightbackend.repository.PassengerRepository;
import com.hexaware.flightbackend.repository.TicketRepository;
import com.hexaware.flightbackend.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private BookingRepository brepository;
	
	@Autowired
	private PassengerRepository prepository;
	
	@Autowired
	private TicketRepository trepository;
	
	
	@Override
	public int addBooking(Booking booking) {
		brepository.save(booking);
		return booking.getBookingId();
	}
	
	@Override
	public int addPassenger(Passenger passenger, int bookingId) {
		Booking booking = brepository.findById(bookingId).get();
		booking.getPassengers().add(passenger);
		passenger.setBooking(booking);
		prepository.save(passenger);
		return passenger.getPid();
	}
	
	@Override
	public Ticket generateTicket(Ticket ticket, int userId, int bookingId) {
		Booking booking = brepository.findById(bookingId).get();
		User user = urepository.findById(userId).get();
		ticket.setBooking(booking);
		ticket.setUser(user);
	
		trepository.save(ticket);
		return ticket;
	}
	
	@Override
	public void updateBooking(Booking bookPay) {
		brepository.save(bookPay);
	}
	
	@Override
	public List<Ticket> getTicket(int uid) {
		User user=urepository.findById(uid).get();
		List<Ticket> tlist=trepository.findByUser(user);
		return tlist;
	}
	
	@Override
	public Booking getBookingById(int bid) {
		
		return brepository.findById(bid).get();
	}

}
