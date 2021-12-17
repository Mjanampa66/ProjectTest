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

import com.FleetSpringBoot.parameters.models.State;
import com.FleetSpringBoot.parameters.service.CountryService;
import com.FleetSpringBoot.parameters.service.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	/* FORMA CLASICA DE HACER EL LISTAR
	 * @GetMapping("/states")
	 *  public String getAllStates(Model model) {
	 *   List<State>  lstates = stateService.getAllStates();
	 *   model.addAttribute("lstates",lstates);
	 *   return "/parameters/statesList";
	 *  }
	 */
	
	public Model addModelAttribuModel(Model model) {
		model.addAttribute("states",stateService.getAllStates());
		model.addAttribute("countries",countryService.getAllCountries());
		return model;
	}
	
	//La otra forma del hacer el  LISTAR cambio de la FORMA CLASICA DE LINEAS COMENTADAS ARRIBA
	//USANDO addModelAttribuModel
	@GetMapping("/states")
	public String getAllStates(Model model) {
		addModelAttribuModel(model);
		return "/parameters/statesList";
	}
	
	//Esta nueva forma de hacer el LISTAR tambien se usa para el ADD
	
	@GetMapping("/statesAdd")
	public String formStatesAdd(Model model){
		addModelAttribuModel(model);
		return "parameters/statesAdd";
	}
	//Guardar States
	
	@PostMapping("/statesSave")
	public String saveState(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}
	
	@GetMapping("/states/edit/{id}")
	public String stateEditForm(@PathVariable Integer id,Model model) {
		addModelAttribuModel(model);
		model.addAttribute("state",stateService.getById(id));
		return "/parameters/stateEdit";
	}
	
	@RequestMapping(value="/statesEdit/{id}",method = {RequestMethod.GET,RequestMethod.PUT})
	public String stateSavePutForm(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}
	
	@GetMapping("/states/details/{id}")
	public String stateDetailsForm(@PathVariable Integer id,Model model) {
		addModelAttribuModel(model);
		model.addAttribute("state",stateService.getById(id));
		return "parameters/stateDetails";
	}
	
	@RequestMapping(value="/states/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String stateDelete(@PathVariable Integer id) {
		stateService.deleteState(id);
		return "redirect:/states";
	}
	
}
