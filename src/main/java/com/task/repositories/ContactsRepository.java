package com.task.repositories;


import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.task.domain.Contact;


public interface ContactsRepository extends MongoRepository<Contact, String>{

}
