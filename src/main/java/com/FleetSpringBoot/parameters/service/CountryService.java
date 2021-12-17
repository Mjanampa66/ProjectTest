package com.FleetSpringBoot.parameters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FleetSpringBoot.parameters.models.Country;
import com.FleetSpringBoot.parameters.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getAllCountries(){
		return	countryRepository.findAll();
	}
	
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}
	
	public void deleteCountry(Integer id) {
	 countryRepository.deleteById(id); 
	}
	
	public Country getById(Integer id) {
		 return countryRepository.findById(id).get();
	}
}
