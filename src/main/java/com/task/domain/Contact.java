package com.task.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contact")
public class Contact {
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	@Id
	private String _id;
	
	private Name name;
	
	private Address address;
	
	private Phone[] phone;
	
	public Phone[] getPhone() {
		return phone;
	}

	public void setPhone(Phone[] phone) {
		this.phone = phone;
	}

	String email;

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	

}
