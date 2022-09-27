package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.model.AuthorDetails;
import com.author.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;

	public AuthorDetails save(AuthorDetails author) {
		return authorRepo.save(author);
		
	}
	

}
