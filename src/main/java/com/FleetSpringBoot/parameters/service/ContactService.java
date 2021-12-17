package com.FleetSpringBoot.parameters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FleetSpringBoot.parameters.models.Contact;
import com.FleetSpringBoot.parameters.models.Country;
import com.FleetSpringBoot.parameters.repository.ContactRepository;

@Service
public class ContactService {
	
	
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getAllContact(){
		return	contactRepository.findAll();
	}
	
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public void deleteContact(Integer id) {
	  contactRepository.deleteById(id);
	}
	
	public Contact getById(Integer id) {
		return contactRepository.findById(id).get();
	}

}
