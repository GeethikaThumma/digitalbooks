package com.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.entity.BookEntity;
import com.book.service.BookService;

//@SpringBootApplication
//public class Application {

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.saveBook(new BookEntity(1, "LNGP", "Geethika", "Familydrama", "junnu", 30.7, "lngp@gmail.com", "1235", 0));
		service.saveBook(new BookEntity(2, "Home", "Preethi", "Comedy", "sister", 700.7, "pree@gmail.com", "12435", 0));
		service.saveBook(new BookEntity(3, "Love", "Neeraja", "Action", "mother", 850.7, "neer@gmail.com", "8235", 0));
		service.saveBook(new BookEntity(4, "You", "Laxminarayana", "Drama", "daddy", 964.7, "lax@gmail.com", "235", 0));

	}
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
