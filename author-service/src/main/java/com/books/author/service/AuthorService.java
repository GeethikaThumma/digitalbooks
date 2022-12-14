package com.books.author.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.author.model.AuthorDetails;
import com.books.author.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepo;
	
	public AuthorDetails save(AuthorDetails author) {
		
        return authorRepo.save(author);
		

	}

	public String validateUser(String username, String password) {
		String dbPassword = authorRepo.filterByPassword(username);
		if (dbPassword != null) {
			if (dbPassword.equals(password)) {
				return "success";
			} else {
				return "failure";
			}
		} else {
			return "false";
		}

	}

	public List<AuthorDetails> getAuthors() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}
	
	
	public Optional<AuthorDetails> getAuthorById(int aId) {
		return authorRepo.findById(aId);

	}

	public Optional<AuthorDetails> getAuthorByName(String username) {

		return authorRepo.findByName(username);
	}


}
