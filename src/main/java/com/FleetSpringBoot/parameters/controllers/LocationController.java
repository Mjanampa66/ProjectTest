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

import com.FleetSpringBoot.parameters.models.Country;
import com.FleetSpringBoot.parameters.models.Location;
import com.FleetSpringBoot.parameters.models.State;
import com.FleetSpringBoot.parameters.service.CountryService;
import com.FleetSpringBoot.parameters.service.LocationService;
import com.FleetSpringBoot.parameters.service.StateService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	
	public Model addAttributeModel(Model model) {
		model.addAttribute("l_locations", locationService.getAllLocations());
		model.addAttribute("lcountry",countryService.getAllCountries());
		model.addAttribute("states",stateService.getAllStates());
		
		return model;
	}
	
	@GetMapping("/locations")
	public String getLocations(Model model) {
		addAttributeModel(model);
		return "parameters/locationList";
	}
	
	/*
	 * @GetMapping("/locations") public String getLocations(Model model) {
	 * List<Location>l_locations = locationService.getAllLocations();
	 * model.addAttribute("l_locations", l_locations); return
	 * "parameters/locationList"; }
	 */

	@GetMapping("/locationAdd")
	public String locationAdd(Model model) {
		addAttributeModel(model);
		return "parameters/locationAdd";
	}
	
	/*
	 * @GetMapping("/locationAdd") public String locationAdd(Location location
	 * ,Model model) { List<Country>lcountry = countryService.getAllCountries();
	 * model.addAttribute("lcountry", lcountry);
	 * locationService.saveLocation(location); return "parameters/locationAdd"; }
	 */
	
	@PostMapping("/locationsSave")
	public String saveLocation(Location location) {
		locationService.saveLocation(location);
		return "redirect:/locations";
	}
	
	@GetMapping("/location/edit/{id}")
	public String editLocation(@PathVariable Integer id, Model model) {
		addAttributeModel(model);
		model.addAttribute("location",locationService.getById(id));
		return "parameters/locationEdit";
	}
	
	@RequestMapping(value="/locationEdit/{id}",method = {RequestMethod.GET,RequestMethod.PUT})
	public String locationSavePutForm(Location location) {
		locationService.saveLocation(location);
		return "redirect:/locations";
	}
	
	@GetMapping("/location/details/{id}")
	public String detailsLocation(@PathVariable Integer id, Model model) {
		addAttributeModel(model);
		model.addAttribute("location",locationService.getById(id));
		return "parameters/locationDetails";
	}
}
