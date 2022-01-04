package com.tb.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.dojosandninjas.models.Dojo;
import com.tb.dojosandninjas.models.Ninja;
//import com.tb.dojosandninjas.repositories.DojoRepo;
import com.tb.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	//injects repo into service file
	private final NinjaRepo ninjaRepo;
	
	//constructor connects service to repo
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
//		this.dojoRepo = dojoRepo;
	}
	
	public List<Ninja>allNinjas(){
		return ninjaRepo.findAll();
	}

	public Ninja findNinja(Long id) {
		Optional<Ninja>optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public Ninja createNinja(Ninja b) {
		return ninjaRepo.save(b);
	}
	
	public Ninja updateNinja(Ninja b) {
		return ninjaRepo.save(b);
	}
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
