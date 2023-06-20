package com.non.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.non.model.Seats;
import com.non.model.Trains;
import com.non.repository.SeatsRepository;
import com.non.repository.TrainsRepository;

@Service
@Transactional(readOnly = true)
public class SeatsServiceImpl implements SeatsService{

	@Autowired
	private SeatsRepository ticketBookingRepository;
	
	@Autowired 
	private TrainsRepository trainsCheckingRepository;
	
	@Override
	public List<Seats> getSeats(){
		return ticketBookingRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Seats addSeat(String tid, Seats seats) {
		Optional<Trains> trainsOptional = trainsCheckingRepository.findById(tid);
		if(!trainsOptional.isPresent()) {
			return null;
		}
		Trains trains= trainsOptional.get();
		seats.setTrains(trains); 
		ticketBookingRepository.save(seats);	
			
		return seats;
	}

	@Override
	public List<Seats> findSeats(String tid) {
		Optional<Trains> trainsOptional = trainsCheckingRepository.findById(tid);	
		if (!trainsOptional.isPresent()) {
			return null;
		}
			return ticketBookingRepository.findSeatsByTid(tid);
	}

	/*@Override
	public void deleteSeats(String sid) {
		ticketBookingRepository.deleteById(sid);
	} */

}
