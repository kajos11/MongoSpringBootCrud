package com.task.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.domain.Contact;
import com.task.repositories.ContactsRepository;

@Service
public class ContactsService {
	
	@Autowired
	private ContactsRepository contactsRepository;
	
	
	public List<Contact> getContacts() {
		List<Contact> contacts= contactsRepository.findAll();
		return contacts;
	}
	
    public Contact saveContact(Contact contact) {
    	Contact contactSaved = contactsRepository.save(contact);
    	return contactSaved;
    }
    
    public Contact updateContact(String id, Contact contact) {
    	contact.set_id(id);
    	Contact contactSaved = contactsRepository.save(contact);
    	return contactSaved;
    }
    
    public Contact getContact(String id) {
    	return contactsRepository.findOne(id);
    }
    
    public String deleteContact(String id) {
    	try {
    		contactsRepository.delete(id);
    		return "Deleted Successfully";
    	}
    	catch(Exception e)
    	{
    		return "Deletion failed";
    	}
    }

}
