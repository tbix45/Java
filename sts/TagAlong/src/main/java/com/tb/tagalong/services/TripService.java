package com.tb.tagalong.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.tagalong.models.Trip;
import com.tb.tagalong.repositories.TripRepository;


@Service
public class TripService {
	private final TripRepository tripRepo;
	public TripService(TripRepository tripRepo) {
		this.tripRepo = tripRepo;
	}
	
	public Trip saveTrip(Trip t) {
		return tripRepo.save(t);
	}
	
	public List<Trip> getAllTrips(){
		return tripRepo.findAll();
	}
	public Trip findOneTrip(Long id) {
		Optional<Trip>optionalTrip = tripRepo.findById(id);
		if(optionalTrip.isPresent()) {
			return optionalTrip.get();
		} else {
			return null;
		}
	}
	
	public List<Trip> findBySearch(String search) {
		return tripRepo.findByLocationContaining(search);
	}
	
	public void deleteTrip(Long id) {
		tripRepo.deleteById(id);
	}
}

