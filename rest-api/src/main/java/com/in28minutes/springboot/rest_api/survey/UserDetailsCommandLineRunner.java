package com.in28minutes.springboot.rest_api.survey;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.rest_api.user.UserDetails;
import com.in28minutes.springboot.rest_api.user.UserDetailsRepository;

@Component
public class UserDetailsCommandLineRunner implements  CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserDetailsRepository repository;
	
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
//		logger.info(Arrays.toString(args));
		
		repository.save(new UserDetails("Ranga", "Admin"));
		
		repository.save(new UserDetails("Ravi", "Admin"));
		repository.save(new UserDetails("John", "User"));
		
	
		
		List<UserDetails> listOfAllUsers = repository.findAll();
		listOfAllUsers.forEach(c->System.out.println(c));
	
		
		List<UserDetails> listOfAdminUsers = repository.findByRole("Admin");
		
		
		listOfAdminUsers.forEach(e->System.out.println(e));
		
		
		
	}

}