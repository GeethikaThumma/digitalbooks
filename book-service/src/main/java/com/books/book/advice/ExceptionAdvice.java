package com.books.book.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.books.book.exception.BookException;
import com.books.book.model.Model;


@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<?> handleMovieException(BookException me) {
		
		return new ResponseEntity<Model>(new Model(
				"BookException: "+me.getMessage(), 
				me.getClass().toString(), 
				"Something bad happened, please try after some time"
			),HttpStatus.OK);
	}

}
