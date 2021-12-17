package com.FleetSpringBoot.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FleetSpringBoot.parameters.models.Country;
import com.FleetSpringBoot.parameters.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countries")
	public String getCountry(Model model){
		List<Country>countries = countryService.getAllCountries();
		model.addAttribute("lcountries", countries);
		 return "parameters/countryList";
	}
	
	@GetMapping("/countriesAdd")
	public String formCountriAdd(){
		
		return "parameters/countryAdd";
	}
	
	@GetMapping("/countriesEdit/{id}")
	public String formCountriEdit(@PathVariable Integer id, Model model){
		Country country = countryService.getById(id);
		model.addAttribute("ecountry", country);
		return "parameters/countryEdit";
	}
	
	@GetMapping("/countriesDetails/{id}")
	public String formCountriDetails(@PathVariable Integer id, Model model){
		Country country = countryService.getById(id);
		model.addAttribute("ecountry", country);
		return "parameters/countryDetails";
	}
	
	
	@PostMapping("/countries")
	public String saveCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="/countries/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String deleteCountry(@PathVariable Integer id) {
		countryService.deleteCountry(id);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="/countries/update/{id}",method = {RequestMethod.GET,RequestMethod.PUT})
	public String updateCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}
	//metodo q retorna un json de paises, para hacer el combobox de addLocation
	//cuando se selecciona un pais, en otro combo, se cargan todos us estados de ese pais
	@GetMapping("parameters/country/{id}")
	@ResponseBody
	public Country getCountryId(@PathVariable Integer id) {
		return countryService.getById(id);
	}

}
