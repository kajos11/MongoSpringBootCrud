package com.task.controller;



import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.ArgumentMatcher.*;
import org.mockito.ArgumentMatchers;

import com.task.domain.Contact;
import com.task.service.ContactsService;

@ExtendWith(MockitoExtension.class)
public class ContactsControllerTest {

	 
	
	@InjectMocks
	private ContactsController contactsController;
	
	
	@Mock
	private ContactsService contactsService;
	
	
	
	@Test
	public void test_getContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setEmail("email@gmail.com");
		contacts.add(contact);
		when(contactsService.getContacts()).thenReturn(contacts);
		List<Contact> responseContacts = contactsController.getContacts();
		Assertions.assertEquals(responseContacts.size(), contacts.size());
		Assertions.assertEquals(contact.getEmail(),responseContacts.get(0).getEmail());
	}
	
	@Test
	public void test_saveContact() {
		Contact contact = new Contact();
		contact.setEmail("newemail.com");
		when(contactsService.saveContact(ArgumentMatchers.<Contact>any())).thenReturn(contact);
		Contact responseContact = contactsController.saveContact(contact);
		Assertions.assertEquals(contact.getEmail(),responseContact.getEmail());
	}
	
	@Test
	public void test_updateContact() {
		Contact contact = new Contact();
		contact.setEmail("updatedemail.com");
		when(contactsService.updateContact(ArgumentMatchers.<String>any(), ArgumentMatchers.<Contact>any())).thenReturn(contact);
		Contact responseContact = contactsController.updateContact(contact,"123");
		Assertions.assertEquals(contact.getEmail(),responseContact.getEmail());
	}
	
	@Test
	public void test_getContact() {
		Contact contact = new Contact();
		contact.setEmail("updatedemail.com");
		when(contactsService.getContact(ArgumentMatchers.<String>any())).thenReturn(contact);
		Contact responseContact = contactsController.getContact("123");
		Assertions.assertEquals(contact.getEmail(),responseContact.getEmail());
	}
	
	@Test
	public void test_deleteContact() {
		when(contactsService.deleteContact((ArgumentMatchers.<String>any()))).thenReturn("Successfully deleted");
		String response = contactsController.deleteContact("123");
		Assertions.assertEquals("Successfully deleted",response);
	}
	
	
	
}
