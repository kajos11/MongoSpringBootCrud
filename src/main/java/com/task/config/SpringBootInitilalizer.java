package com.task.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.task.repositories.ContactsRepository;

@ComponentScan(basePackages = "com.task")
@EnableMongoRepositories(basePackageClasses = ContactsRepository.class)
@SpringBootApplication
public class SpringBootInitilalizer {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitilalizer.class, args);
	}

}
