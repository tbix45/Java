package com.tb.tvshows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.tvshows.models.Show;
import com.tb.tvshows.repositories.ShowRepository;


@Service
public class ShowService {
	private final ShowRepository showRepo;
	public ShowService(ShowRepository showRepo) {
		this.showRepo = showRepo;
	}
	
	public Show saveShow(Show s) {
		return showRepo.save(s);
	}
	
	public List<Show> getAllShows(){
		return showRepo.findAll();
	}
	public Show findOneShow(Long id) {
		Optional<Show>optionalShow = showRepo.findById(id);
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
}
