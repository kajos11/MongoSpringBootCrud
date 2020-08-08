package com.task.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.domain.Contact;
import com.task.service.ContactsService;

@RestController
public class ContactsController {
	
	@Autowired
	private ContactsService contactsService;
	
	
	@GetMapping("/contacts")
    public List<Contact> getContacts(){
		return contactsService.getContacts();
    }
	
	@PostMapping("/contacts")
	public Contact saveContact(@RequestBody Contact contact) {
		return contactsService.saveContact(contact);
	}
	
	@PutMapping("/contacts/{id}")
	public Contact updateContact(@RequestBody Contact contact, @PathVariable String id) {
		return contactsService.updateContact(id, contact);
	}
	
	@GetMapping("/contacts/{id}")
	public Contact getContact(@PathVariable String id) {
		return contactsService.getContact(id);
	}
	
	@DeleteMapping("/contacts/{id}")
	public String deleteContact(@PathVariable String id) {
		return contactsService.deleteContact(id);
	}
	

}
