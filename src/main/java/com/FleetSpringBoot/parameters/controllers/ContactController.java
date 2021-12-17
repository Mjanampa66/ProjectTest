package com.FleetSpringBoot.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FleetSpringBoot.parameters.models.Contact;
import com.FleetSpringBoot.parameters.service.ContactService;

@Controller
public class ContactController {
	
	//Linea para primera Prueba de Git
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public String getContactos(Model model) {
		List<Contact>contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);
		return "parameters/contactList";
	}
	//Segunda Linea paara Prueba GIT
	@GetMapping("/contactsAdd")
	public String formAddContact() {
		return "parameters/contactsAdd";
	}
	
	@PostMapping("/saveContacts")
	public String saveContact(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/contactsEdit/{id}")
	public String editContact(@PathVariable Integer id,Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("econtacts", contact);
		return "parameters/contactsEdit";
	}
	
	@PostMapping("/contacts/edit/{id}")
	public String saveEditContac(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/contactsDetails/{id}")
	public String contactsDetails(@PathVariable Integer id,Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("econtacts", contact);
		return "parameters/contactsDetails";
	}
	
	@RequestMapping(value="/contacts/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String deleteContact(@PathVariable Integer id) {
		contactService.deleteContact(id);
		return "redirect:/contacts";
	}

}
	
