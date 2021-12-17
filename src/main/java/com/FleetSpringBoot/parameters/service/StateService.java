package com.FleetSpringBoot.parameters.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FleetSpringBoot.parameters.models.State;
import com.FleetSpringBoot.parameters.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public List<State> getAllStates(){
		return	stateRepository.findAll();
	}
	
	public void saveState(State state) {
		stateRepository.save(state);
	}
	
	public void deleteState(Integer id) {
		stateRepository.deleteById(id); 
	}
	
	public State getById(Integer id) {
		 return stateRepository.findById(id).get();
	}
}
