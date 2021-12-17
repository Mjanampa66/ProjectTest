package com.FleetSpringBoot.parameters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FleetSpringBoot.parameters.models.Location;
import com.FleetSpringBoot.parameters.repository.LocationsRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationsRepository locationsRepository;
	
	public List<Location> getAllLocations(){
		return	locationsRepository.findAll();
	}
	
	public void saveLocation(Location location) {
		locationsRepository.save(location);
	}
	
	public void deleteLocation(Integer id) {
		locationsRepository.deleteById(id); 
	}
	
	public Location getById(Integer id) {
		 return locationsRepository.findById(id).get();
	}

}
