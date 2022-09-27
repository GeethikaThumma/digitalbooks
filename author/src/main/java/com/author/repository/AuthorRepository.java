package com.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.model.AuthorDetails;

public interface AuthorRepository extends JpaRepository<AuthorDetails,Integer> {
	

}
