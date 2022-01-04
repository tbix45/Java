package com.tb.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.dojosandninjas.models.Dojo;
import com.tb.dojosandninjas.repositories.DojoRepo;

@Service
public class DojoService {
	
	//injects repo into service file
	private final DojoRepo dojoRepo;
	
	//constructor connects service to repo
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo>allDojos(){
		return dojoRepo.findAll();
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo>optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public Dojo createDojo(Dojo b) {
		return dojoRepo.save(b);
	}
	
	public Dojo updateDojo(Dojo b) {
		return dojoRepo.save(b);
	}
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}

}
