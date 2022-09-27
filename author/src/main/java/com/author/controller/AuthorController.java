package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.AuthorDetails;
import com.author.model.JwtRequest;
import com.author.model.JwtResponse;
import com.author.service.AuthorService;

@RestController
@RequestMapping("/api/v1/digitalbooks/author")
@CrossOrigin
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/signup")
	
    public ResponseEntity<?> registerUser(@RequestBody AuthorDetails Ad) {
      
        AuthorDetails author= new AuthorDetails();
        author.setAuthorEmailId(Ad.getAuthorEmailId());
        author.setUsername(Ad.getUsername());
        author.setPassword(Ad.getPassword());
        authorService.save(author);
        return ResponseEntity.ok(new JwtResponse("User registered successfully"));
    }
	
	@PostMapping("/login")
	public String login(@RequestBody AuthorDetails Ad){
		AuthorDetails author= new AuthorDetails();
//        author.setAuthorEmailId(Ad.getAuthorEmailId());
        author.setUsername(Ad.getUsername());
        author.setPassword(Ad.getPassword());
//		return ResponseEntity.ok(new JwtResponse("Login successfully"));
        return "redirect:/login.html";		
		
	}
	
//	@PostMapping("/{authorId}/books")
//	public 
	

}
