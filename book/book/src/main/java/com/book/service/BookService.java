package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookEntity;
import com.book.exceptions.BookExceptions;
import com.book.mode.PurchaseInfo;
import com.book.repository.BookRepository;


@Service
public class BookService {

	
	@Autowired
    private BookRepository bookRepo;

 

    public List<BookEntity> fetchAllBooks() {
        return bookRepo.findAll();

    }
    
    public BookEntity saveBook(BookEntity be) {

		return bookRepo.save(be);
	}
   
 
    public BookEntity getBookById(int bookId) throws Exception {
        Optional<BookEntity> optional = bookRepo.findById(bookId);
        if (Optional.empty() != null) {
            throw new BookExceptions("Book with id(" + bookId + ") not found");
        } else {
            return optional.get();
        }
    }

 

    public List<BookEntity> getBookByName(String name) {
        return bookRepo.findByName(name);
    }

 

    public List<BookEntity> getBooks(String category, String author, double price, String publisher){
        List<BookEntity> finalList = null;
        
        if (category != null && author != null && price != 0 && publisher != null) {
                
            finalList = bookRepo.findbycap(category,author,price,publisher);
        
        }else return null;
        
        return finalList;
    }
    


	public void bookPurchase( String subId, PurchaseInfo purchaseInfo) {
		System.out.println(subId);
		System.out.println(purchaseInfo.getBookId());
//		System.out.println(purchaseInfo.getReaderInfo().getName());
//		System.out.println(purchaseInfo.getReaderInfo().getEmail());
//		
	
	}

	
}