package com.books.book.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.books.book.entity.BookEntity;
import com.books.book.entity.BuyBook;
import com.books.book.exception.BookException;
import com.books.book.model.AuthorResponse;
import com.books.book.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	@Autowired
    private KafkaTemplate<String, BookEntity> kafkaTemplate;
	
	private static final String TOPIC = "kafka-topic-sample";

    @GetMapping("/publish")
    public String publishBook() {

//        int id = (int)(Math.floor(Math.random()*100));
        kafkaTemplate.send(TOPIC, new BookEntity(1,"java","author",1,120.5,"ABC publishers","20/07/2020","studies",true,"nill","30/07/2020"));

        return "Book published successfully: "+LocalDateTime.now();
    }
	
	
	
	
	
	@PostMapping("/{authorId}/books")
	public AuthorResponse createBook(@PathVariable int authorId, @RequestBody BookEntity book) {
		AuthorResponse response = new AuthorResponse();

		try {
			BookEntity bookEntity = bookService.createBookByAuthor(authorId, book);
			response.setBookData(bookEntity);
			response.setMessage("Bookcreated");
		} catch (BookException e) {

			response.setException(e.getMessage());
		}

		return response;
	}
	
	@PutMapping("/{authorId}/books/{bookId}")
	public AuthorResponse updateBook(@PathVariable int authorId,@PathVariable int bookId, @RequestBody BookEntity book) {
		AuthorResponse response = new AuthorResponse();
		try {
			BookEntity bookentity = bookService.updateBookByAuthor(authorId,bookId, book);
			response.setBookData(bookentity);
			response.setMessage("Book is updated");
		} catch (BookException e) {

			response.setException(e.getMessage());
		}
		return response;

		
	}
	
	@GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.fetchAllBooks();
    }
	
	@GetMapping("/{id}")
	public BookEntity getBookById(@PathVariable int bookId) throws Exception {
		return bookService.getBookById(bookId);
	}
	
	
	@GetMapping("/search")
	public List<BookEntity> getBooks(@RequestParam("category") String category, 
							   		 @RequestParam("authorName") String authorName, 
							         @RequestParam("price") double price, 
							         @RequestParam("publisher") String publisher){
		return bookService.getBooks(category,authorName,price,publisher);
	}
	
	@PostMapping("/buy")
    public String buyBook(@RequestBody BuyBook buyBooks)
    {
        System.out.println("controller");
        return  bookService.saveData(buyBooks);
    }
	
	@PostMapping("/block/{authorId}/{bookId}")
	public AuthorResponse blockBook(@PathVariable int authorId, @PathVariable int bookId) {
		AuthorResponse response = new AuthorResponse();
		try {
			String message = bookService.blockBook(authorId, bookId);
			response.setMessage(message);
		} catch (Exception e) {
			response.setException(e.getMessage());
		}
		return response;
	}

	
	
}
